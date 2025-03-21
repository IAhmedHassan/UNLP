.data
  V: .word 5,4,3,2,1,-1,-2,-3,-4,10
  POS: .word 0
.text
                  dadd $t0, $0, $0 ; t0 -> 0, contador
                  daddi $t1, $0, 10 ; t1 -> tamaño del vector
                  daddi $t4, $0, V ; t4 -> dir inicial del vector
  loop:           beqz $t1, fin ; salta cuando termina de recorrer el vector
                  ld $t2, 0($t4) ; t2 -> valor actual del vector
                  slti $t3, $t2, 0 ; comprueba si t2 es menor a 0
                  bnez $t3, no_es_positivo ; Si t2 es 0 no es positivo, no cuenta
                  daddi $t0, $t0, 1 ; suma 1 al contador
  no_es_positivo: daddi $t1, $t1, -1 ; decrementa la cantidad de valores del vector a evaluar
                  daddi $t4, $t4, 8 ; pasa al próximo valor del vector
                  j loop
  fin:            sd $t0, POS($0) ; guarda el contador en POS
                  halt




