.data
  ultima_letra: .ascii "h"
  string: .asciiz ""

.text
  ; t0 : dir string
  ; t1 : letra actual
  ; t2 : cant veces que se repite letra
  ; t3 : ultima letra
  ; t4 : repetidor letra

                  daddi $t0, $0, string
                  daddi $t1, $0, 97
                  daddi $t2, $0, 1
                  lb $t3, ultima_letra($0)
  loop:           beq $t1, $t3, fin
                  dadd $t4, $0, $t2
  loopletra:      beqz $t4, fin_loop_letra
                  sb $t1, 0($t0)
                  daddi $t0, $t0, 1
                  daddi $t4, $t4, -1
                  j loopletra
  fin_loop_letra: daddi $t1, $t1, 1
                  daddi $t2, $t2, 1
                  j loop
  fin:            sb $0, 0($t0)
                  halt

