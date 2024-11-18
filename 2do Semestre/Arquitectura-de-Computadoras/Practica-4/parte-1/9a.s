.data
  string: .asciiz "ArquiTectuRa de ComPutaDoras10"
  LONGITUD: .byte 0

.text
  ; t0 : direccion del string
  ; t1 : elemento actual
  ; t2 : longitud
  daddi $t0, $0, string
  dadd $t2, $0, $0
  loop: lb $t1, 0($t0)
        beqz $t1, fin
        daddi $t2, $t2, 1
        daddi $t0, $t0, 1
        j loop
  fin:  sd $t2, LONGITUD($0)
        halt