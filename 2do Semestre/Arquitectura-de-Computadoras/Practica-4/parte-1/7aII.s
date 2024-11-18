.data
  V: .byte 1,2,3,10,5,6,18,4,3,0
  MAX: .byte 0
.text
  ; t0 : direccion del elemento actual del vector
  ; t1 : elemento maximo
  ; t2 : cantidad de veces que debe iterar
  ; t3 : elemento actual
  ; t4 : comparación

                daddi $t0, $0, V
                daddi $t1, $0, 0
                daddi $t2, $0, 10
  loop:         beqz $t2, fin
                lb $t3, 0($t0)
                slt $t4, $t1, $t3
                beqz $t4, no_es_mayor
                dadd $t1, $0, $t3
  no_es_mayor:  daddi $t0, $t0, 1
                daddi $t2, $t2, -1
                j loop
  fin:          sb $t1, MAX($0)
                halt