.data
  A: .byte 10
  B: .byte 8
  C: .byte 1

.text
                  lb $s0, A($0)
                  lb $s1, B($0)

                  bnez $s0, no_es_igual
                  daddi $t0, $0, 0
                  sb $0, C($0)
                  j fin
480GB

  no_es_igual:    slt $t0, $s1, $s0
                  beqz $t0, B_mayor_que_A
                  daddi $t0, $0, 2
                  dmul  $t1, $s0, $t0
                  sb $t1, C($0)
                  j fin

  B_mayor_que_A:  sb $s1, C($0)


  fin:            halt 
