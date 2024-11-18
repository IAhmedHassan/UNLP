.data
  N: .byte 3
  F: .byte 0

.text
          lb $s0, N(0) ; s0 = N
          dadd $t0, $0, $0 ; t0 = resultado
          daddi $t1, $0, 1 ; guardo 1 en t1 pa ir restando
 
  loop:   beqz $s0, sigue
          dmul $t0, $t0, $s0
          dsub $s0, $s0, $t1
          j loop
 
  sigue:  sd $s0, F($0)
          halt
