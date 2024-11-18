.data
  V: .word 0

.text
  ; t0 : dirección al vector
  ; t1 : valor actual
  ; t2 : valor anterior
  ; t3 : valor anterior al anterior
  ; t4 : cant iteraciones

        daddi $t0, $0, V
        daddi $t1, $0, 1
        daddi $t2, $0, 0
        daddi $t3, $0, 0
        daddi $t4, $0, 10
        sd $t2, 0($t0)
        sd $t1, 8($t0)
        daddi $t0, $t0, 16
        daddi $t4, $t4, -2
  loop: beqz $t4, fin
        dadd $t3, $t2, $0
        dadd $t2, $t1, $0
        dadd $t1, $t2, $t3
        sd $t1, 0($t0)
        daddi $t0, $t0, 8
        daddi $t4, $t4, -1
        j loop

  fin:  halt
        

