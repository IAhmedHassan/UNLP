.data
  V: .word 5,2,6

.text
        dadd $t0, $0, $0
        dadd $t2, $0, $0
        daddi $t3, $t0, 3
loop:   beqz $t3, fin
        ld $t1, V($t2)
        dadd $t0, $t0, $t1
        daddi $t2, $t2, 8
        daddi $t3, $t3, -1
        j loop
fin:    halt