program archivos;

type
  {Tipos}
    archivo = file of integer;
    
var
  {Variables}
    archivo_logico : archivo;
    nombre_fisico : string;
    i : integer;

begin
  write('Ingrese nombre del archivo: '); readln(nombre_fisico);
  assign(archivo_logico, nombre_fisico);
  rewrite(archivo_logico);
  write('Ingrese un número: '); readln(i);
  while (i <> 30000) do begin
    write(archivo_logico,i);
    write('Ingrese un número: '); readln(i);
  end;
  close(archivo_logico);
end.

