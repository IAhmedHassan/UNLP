.data
  resultado: .word 0
  CONTROL: .word32 0x10000
  DATA: .word32 0x10008

.text
  lwu $s6, CONTROL($0)
  lwu $s7, DATA($0)
  daddi $t0, $0, 8
  sd $t0, 0($s6)
  ld $a0, 0($s7)
  sd $t0, 0($s6)
  ld $a1, 0($s7)
  jal potencia
  sd $v0, resultado($0)
  halt

  potencia: daddi $v0, $0, 1
  lazo:     beqz $a1, terminar
            daddi $a1, $a1, -1
            dmul $v0, $v0, $a0
            j lazo
  terminar: jr $ra