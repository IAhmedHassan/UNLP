program numeroYSuDoble;
var X,X2,num : real; i : integer; band: boolean;
begin
  write('Escriba un numero: '); read(X);
  X2 := X * 2;
  i := 10;
  band := true;
  while((i <> 0) and band ) do begin
    write('escribe el doble de ',X,': '); read(num);
    if (num = X2) then begin
      writeln('Correcto!');
      band := false;
    end;
    i := i -1;
  end;
  if (band) then writeln('No se ha ingresado el doble de ', X);
end.