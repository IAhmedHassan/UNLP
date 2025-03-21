.data
  string: .asciiz "ArquiTectuRa de ComPutaDoras10"
  cant_mayusculas: .byte 0

.text
  ; t0 : dir string
  ; t1 : elem string
  ; t2 : cant mayus
  ; t3 : resultado stl
  
                daddi $t0, $0, string
                dadd $t2, $0, $0
  loop:         lb $t1, 0($t0)
                beqz $t1, fin
                slti $t3, $t1, 65
                bnez $t3, no_es_mayus
                slti $t3, $t1, 91
                beqz $t3, no_es_mayus
                daddi $t2, $t2, 1
  no_es_mayus:  daddi $t0, $t0, 1
                j loop
  fin:          sb $t2, cant_mayusculas($0)
                halt