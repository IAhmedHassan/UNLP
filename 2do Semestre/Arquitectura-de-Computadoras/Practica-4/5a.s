.data
  A:  .byte 4
  B:  .byte 2
  S:  .byte 0 ; A + B
  P:  .byte 0 ; 2 + (A*B)
  D:  .byte 0 ; A^2 / B

.text
      lb $t0, A($0)
      lb $t1, B($0) 
      
      dadd $a0, $t0, $t1
      sb $a0, S($0)

      dmul $a1, $t0, $t1
      daddi $a1, $a1, 2
      sb $a1, P($0)

      dmul $t2, $t0, $t0
      ddiv $a2, $t2, $t1
      sb $a2, D($0)
      
      
      
      halt