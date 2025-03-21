.data
  X:       .byte 20
  Y:       .byte 35
  CONTROL: .word 0x10000
  DATA:    .word 0x10008
  violeta: .byte 255,0,255,0

.text
  ; s6 : control
  ; s7 : data
  ; t0 : handler control
  ; t1 : handler data



  ld $s6, CONTROL($0)
  ld $s7, DATA($0)

  loop: daddi $t0, $0, 8
        sb $t0, 0($s6)
        lbu $a0, 0($s7)
        sb $t0, 0($s6)
        lbu $a1, 0($s7)
      
        jal pintar
        j loop
        halt

  pintar: lwu $t1, violeta($0)
          sw $t1, 0($s7)
          sb $a0, 5($s7)
          sb $a1, 4($s7)
          daddi $t0, $0, 5
          sd $t0, 0($s6)
          jr $ra

