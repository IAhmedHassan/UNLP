.data
  X:       .byte 1
  Y:       .byte 49
  CONTROL: .word 0x10000
  DATA:    .word 0x10008
  negro:   .byte 0,0,0,0

.text
  ; s6 : control
  ; s7 : data
  ; t0 : handler control 1
  ; t1 : handler data



                  ld $s6, CONTROL($0)
                  ld $s7, DATA($0)
                
                  lb $a0, X($0)
                  lb $a1, Y($0)
                  daddi $a2, $0, negro
                  jal pintar
                  halt

  pintar:         dadd $t1, $0, $a2
                  sb $a0, 5($s7)
                  sb $a1, 4($s7)
                  daddi $t0, $0, 5
  loopPintar:     slti $t2, $t1, 255
                  beqz $t2, finLoopPintar
                  sw $t1, 0($s7)
                  sd $t0, 0($s6)
                  daddi $t1, $t1, 1
                  j loopPintar
  finLoopPintar:  jr $ra




