program operacionesCombinadas;
var op: char; num, total : integer;
begin
  total := 0;
  write('Ingrese la operación: '); readln(op);
  if ((op <> '+') and (op <> '-')) then writeln('Error.')
  else begin
    write('Ingrese el primer numero: '); read(num);
    while (num <> 0) do begin
      if (op = '+') then total := total + num
      else total := total - num;
      write('Ingrese otro numero: '); read(num);
    end;
  writeln('El resultado es: ', total);
  end;
end.