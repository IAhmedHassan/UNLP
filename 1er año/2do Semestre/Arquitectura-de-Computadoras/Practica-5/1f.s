.data
  CONTROL: .word32 0x10000
  DATA: .word 0x10008

.text
  lwu $s6, CONTROL($0)
  lwu $s7, DATA($0)
  daddi $t0, $0, 8
  sd $t0, 0($s6)
  lb $s0, 0($s7)
  dadd $a1, $0, $s0 
  daddi $a0, $0, 2
  jal potencia
  dadd $s1, $0, $v0
  dadd $a1, $0, $s0 
  daddi $a0, $0, 3
  jal potencia
  dadd $s2, $0, $v0
  daddi $t0, $0, 1
  dadd $s1, $s1, $s2
  sd $s1, 0($s7)
  sd $t0, 0($s6)
  halt


  potencia: daddi $v0, $0, 1
  lazo:     beqz $a1, terminar
            daddi $a1, $a1, -1
            dmul $v0, $v0, $a0
            j lazo
  terminar: jr $ra