.data
  X:        .byte 45
  Y:        .byte 0
  color:    .byte 255,0,0,0
  CONTROL:  .word32 0x10000
  DATA:     .word32 0x10008

.code
            lwu $s6, CONTROL($0)
            lwu $s7, DATA($0)
            lwu $t0, color($0)
            sw $t0, 0($s7)
            ;--------------------           
            lbu $t2, X($0)
            daddi $t4, $0, 50
            daddi $t5, $0, 5
  loop:     sb $t1, 4($s7)
            ;--------------------
            daddi $t3, $0, 5
            sd $t3, 0($s6)
            daddi $t2, $t2, 1
            bne $t4, $t2, loop
            ;--------------------
            daddi $t1, $t1, 1
            bne $t5, $t1, loop
