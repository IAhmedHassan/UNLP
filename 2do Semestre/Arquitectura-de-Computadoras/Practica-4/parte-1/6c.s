.data
  V: .word 5, 2, 6

.text
      dadd $t0, $0, $0 ; t0 -> 0
      daddi $t3, $0, 3 ; t3 -> 3, tamaño del vector
      daddi $t2, $0, V ; t2 -> dir de V, puntero del vector
loop: beqz $t3, fin ; si t3 es 0 salta a fin
      ld $t1, 0($t2) ; t1 -> valor alojado en l puntero de t2
      dadd $t0, $t0, $t1 ; suma t1 en t0
      daddi $t2, $t2, 8 ; incrementa el puntero
      daddi $t3, $t3, -1 ; decrementa el contador
      j loop

fin: halt