.data
  cadena: .asciiz "ABCdef1,q"
  cadena2: .ascii "ABCdef11"
  cadena3: .asciiz "ABCdef1111111"
  num: .byte -2,2,2,2,2,2
  menos_dos: .word -2
  A_con_acento: .ascii "Á"
  E_con_acento: .ascii "É"

.code
  ld $t1, num($0) ; 00000202020202fe
  lb $t2, num($0) ; fffffffffffffffe
  lbu $t3, num($0) ; 00000000000000fe

  ld $t4, A_con_acento($0)
  lb $t5, A_con_acento($0)
  lbu $t6, A_con_acento($0)
  halt