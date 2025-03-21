.data
  V: .word 5,2,6
  RES: .word 0

.text
  daddi $t2, $0, 0
  ld $t0, V($t2)
  daddi $t2, $t2, 8
  ld $t1, V($t2)
  dadd $t0, $t0, $t1
  daddi $t2, $t2, 8
  ld $t1, V($t2)
  dadd $t0, $t0, $t1