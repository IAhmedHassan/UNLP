.data
  CONTROL: .word 0x10000
  DATA:    .word 0x10008
  msj_bienvenida: .asciiz "Ingrese una clave de 4 caracteres (Quedan "
  msj_bienvenida2: .asciiz " intentos): "
  msj_pass_correcta: .asciiz "Clave correcta: Acceso permitido"
  msj_pass_incorrecta: .ascii "Clave incorrecta.", 10,0
  pass: .asciiz "1234"
  intento: .byte 0

.text
  ; s6 : control
  ; s7 : data
  ; t0 : handler control-data
  ; t1 : pass
  ; t2 : dir intento
  ; t3 : lecturas restantes
  ; t4 : 
  ; t5 : cant intentos

  ld $s6, CONTROL($0)
  ld $s7, DATA($0)
                        daddi $t5, $0, 5
  inicio_lectura:       beqz $t5, fin
                        daddi $t0, $0, msj_bienvenida
                        daddi $t3, $0, 4
                        sd $t0, 0($s7)
                        daddi $t0, $0, 4
                        sd $t0, 0($s6)
                        sd $t5, 0($s7)
                        daddi $t0, $0, 1
                        sd $t0, 0($s6)
                        daddi $t0, $0, msj_bienvenida2
                        sd $t0, 0($s7)
                        daddi $t0, $0, 4
                        sd $t0, 0($s6)
                        daddi $t2, $0, intento
  lectura_contrasenha:  beqz $t3, fin_lectura 
                        daddi $t0, $0, 9
                        sd $t0, 0($s6)
                        lb $t4, 0($s7)
                        sb $t4, 0($t2)
                        daddi $t2, $t2, 1
                        daddi $t3, $t3, -1
                        j lectura_contrasenha
  fin_lectura:          ld $t1, pass($0)
                        daddi $t2, $t2, -4
                        ld $t4, 0($t2)
                        daddi $t0, $0, 6
                        sb $t0, 0($s6)
                        beq $t1, $t4, correcta
                        daddi $t0, $0, msj_pass_incorrecta
                        daddi $t5, $t5, -1
                        sd $t0, 0($s7)
                        daddi $t0, $0, 4
                        sd $t0, 0($s6)
                        j inicio_lectura
  correcta:             daddi $t0, $0, msj_pass_correcta
                        sd $t0, 0($s7)
                        daddi $t0, $0, 4
                        sd $t0, 0($s6)
  fin:                  halt



