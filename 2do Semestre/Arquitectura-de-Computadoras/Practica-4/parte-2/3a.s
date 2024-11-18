.data
  CONTROL: .word 0x10000
  DATA: .word 0x10008
.text
  ; s6 : control
  ; s7 : data
  ; t0 : handler control-data
  ; t1 : numero 1
  ; t2 : numero 2
  ; t3 : suma

  ld $s6, CONTROL($0)
  ld $s7, DATA($0)
  daddi $t0, $0, 8
  sd $t0, 0($s6)
  ld $t1, 0($s7)
  sd $t0, 0($s6)
  ld $t2, 0($s7)
  dadd $t3, $t2, $t1
  daddi $t0, $0, 1
  sd $t3, 0($s7)
  sd $t0, 0($s6)
  halt

  