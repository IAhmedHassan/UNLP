; Aun no terminado. Por alguna razón solo suma :c

.data
  op_mas: .ascii "+"
  op_menos: .ascii "-"
  op_multiplicacion: .ascii "*"
  op_division: .ascii "/"
  CONTROL: .word 0x10000
  DATA: .word 0x10008

.text

  ; s6 : control
  ; s7 : data
  ; t0 : handler c-d
  ; a0 : num1
  ; a1 : num2
  ; s0 : operador
            ld $s6, CONTROL($0)
            ld $s7, DATA($0)
            lb $t5, op_mas($0)
            lb $t2, op_menos($0)
            lb $t3, op_multiplicacion($0)
            lb $t4, op_division($0)
            daddi $t0, $0, 8
            daddi $t1, $0, 9
            sd $t0, 0($s6)
            ld $a0, 0($s7)
  infinito: sd $t1, 0($s6)
            lwu $s0, 0($s7)
            sd $t0, 0($s6)
            ld $a1, 0($s7)
            beq $s0, $t5, suma
            beq $s0, $t2, resta
            beq $s0, $t3, mult
            beq $s0, $t4, div
  suma:     dadd $v0, $a0, $a1
            j sigue
  resta:    dsub $v0, $a0, $a1
            j sigue
  div:      ddiv $v0, $a0, $a1
            j sigue
  mult:     dmul $v0, $a0, $a1
  sigue:    daddi $t0, $0, 1
            sd $v0, 0($s7)
            sd $t0, 0($s6)
            halt


