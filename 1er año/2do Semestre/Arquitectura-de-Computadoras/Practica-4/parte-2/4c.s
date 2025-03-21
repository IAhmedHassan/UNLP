.data
  Y: .byte 0
  azul: .byte 0,0,255

  CONTROL: .word 0x10000
  DATA: .word 0x10008

.text

                ld $s6, CONTROL($0)
                ld $s7, DATA($0)
                lbu $a0, Y($0)
                lwu $a1, azul($0)
                jal PINTAR_LINEA
                halt

  PINTAR_LINEA: dadd $t0, $0, $0
                daddi $t1, $0, 5
                sw $a1, 0($s7)
                sb $a0, 4($s7)
  PL_loop:      slti $t2, $t0, 50
                beqz $t2, PL_fin
                sb $t0, 5($s7)
                sb $t1, 0($s6)
                daddi $t0, $t0, 1
                j PL_loop
  PL_fin:       jr $ra
