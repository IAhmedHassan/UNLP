program nombrePrograma;
type
  {Tipos}
    archivo = file of integer;

procedure procesar(var cantM, total : integer; i : integer);
begin
    total := total + i;
    if (i < 1500) then
      cantM := cantM + 1;
end;
    
var
  {Variables}
    archivo_logico : archivo;
    nombre_fisico : string;
    i, cantM, total : integer;
    prom : real;

begin
  total := 0;
  cantM := 0;
  write('ingrese nombre del archivo: '); readln(nombre_fisico);
  assign(archivo_logico, nombre_fisico);
  reset(archivo_logico);
  while not EOF(archivo_logico) do begin
    read(archivo_logico,i); 
    procesar(cantM, total, i);
    writeln(i);
  end;
  prom := total / FileSize(archivo_logico);
  writeln('Promedio: ', prom:0:2);
  writeln('cant menores a 1500: ', cantM);
  close(archivo_logico);
end.
