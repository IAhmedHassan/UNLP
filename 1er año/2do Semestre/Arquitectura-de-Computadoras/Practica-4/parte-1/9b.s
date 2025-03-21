.data
  string: .asciiz "arquitectura de computadoras"
  elem:   .ascii "a"
  cant_elem: .byte 0

.text
  ; t0 : dir string
  ; t1 : elem string
  ; t2 : elem a comparar
  ; t3 : cant elem
  
              daddi $t0, $0, string
              lb $t2, elem($0)
              dadd $t3, $0, $0
  loop:       lb $t1, 0($t0)
              beqz $t1, fin
              bne $t1, $t2, no_es_elem
              daddi $t3, $t3, 1
  no_es_elem: daddi $t0, $t0, 1
              j loop
  fin:        sb $t3, cant_elem($0)
              halt
