program Ejercicio2;
var
    num: integer;
begin
  writeln('');
  writeln('---------------------------------------------------------');
  writeln('');
  
  writeln ('programa para imprimir valor absoluto.');
  writeln('');
  write('ingrese un número: ');
  read(num);
  if (num > 0) then writeln('|', num,'| = ', num)
  else writeln('|', num,'| = ', (num * -1));
end.