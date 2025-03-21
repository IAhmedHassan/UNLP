.data
  V: .word 1,2,3,4,5,6,7,8,9,10

.text
  ; t0 : puntero al elem actual del vector
  ; t1 : elemento actual
  ; t3 : longitud del vector

        daddi $t0, $0, V
        daddi $t3, $0, 10
  loop: beqz $t3, fin
        ld $t1, 0($t0)
        dadd $t1, $t1, $t1
        sd $t1, 0($t0)
        daddi $t3, $t3, -1
        daddi $t0, $t0, 8
        j loop
  fin:  halt
