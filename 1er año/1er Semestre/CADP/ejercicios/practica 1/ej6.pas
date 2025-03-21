program Ejercicio5;
var
  x, buff, i: integer;
begin
  i:=0;
  writeln('');
  writeln('---------------------------------------------------------');
  writeln('');
  
  writeln ('programa para buscar el doble de X.');
  writeln('');
  
  write('ingresa X: ');
  read(x);
  write('ingresa un número (tenés 10 intentos): ');
  read(buff);
  while ((buff <> (x * 2)) and (i < 10)) do
    begin
      i:= i+1;
      write(buff, ' no es el doble de ', x, '. Ingresa otro número: ');
      read(buff);
    end;
 if buff = (x*2) then writeln('¡Bien hecho! ', buff, ' es el doble de ', x, '.')
 else writeln('Lo siento, superaste los 10 intentos. :c');
end.