program mayor;
var num1, num2 : integer;
begin
  write('1er num: '); read(num1);
  write('2do num: '); read(num2);
  if (num1 = num2) then writeln('Los numeros leíos son iguales.')
  else begin
    if(num1 > num2) then writeln('el mayor es ', num1)
    else writeln('El mayor es ', num2);
  end;
  end.