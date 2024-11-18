.data
  V: .word 0

.text
  ; t0: direccion V
  ; t1: valor actual
  ; t2: cant iteraciones loop
  ; 
  ; t3: 1 si es impar, 0 si es par

                daddi $t0, $0, V
                daddi $t1, $0, 0
                daddi $t2, $0, 10
  loop:         beqz $t2, fin
                daddi $t1, $t1, 1
                andi $t3, $t1, 1
                beqz $t3, no_es_impar
                sd $t1, 0($t0)
                daddi $t2, $t2, -1
                daddi $t0, $t0, 8
  no_es_impar:  j loop
  fin:          halt