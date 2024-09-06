program Ejercicio1;
var
    num1, num2: integer;
begin
  writeln('');
  writeln('---------------------------------------------------------');
  writeln('');
  
  writeln ('programa para leer 2 numeros enteros y definir el mayor.');
  writeln('');
  write('ingrese el 1er num: ');
  read(num1);
  write('ingrese el 2do num: ');
  read(num2);
  if (num1 = num2) then writeln('los números son iguales.')
  else    if (num1 > num2) then writeln('el mayor es ', num1)
    else writeln('el mayor es ', num2);
end.