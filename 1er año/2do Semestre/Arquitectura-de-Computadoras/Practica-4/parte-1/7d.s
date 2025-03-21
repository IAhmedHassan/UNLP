.data
  V: .word 1,2,3,4,5,6,7,8,9,11
  W: .word 0

.text
  ; t0 : puntero a V
  ; t1 : elemento act de V
  ; t2 : puntero a W
  ; t3 : cant de iteraciones
  ; t4 : 1 si es impar, 0 si es par

                    daddi $t0, $0, V
                    daddi $t2, $0, W
                    daddi $t3, $0, 10
  loop:             beqz $t3, fin
                    ld $t1, 0($t0)
                    andi $t4, $t1, 1
                    beqz $t4, no_es_impar
                    sd $t1, 0($t2)
                    daddi $t2, $t2, 8
  no_es_impar:      daddi $t0, $t0, 8
                    daddi $t3, $t3, -1
                    j loop
  fin:              halt