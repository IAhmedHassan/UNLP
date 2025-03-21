program revisandoInversiones;
var cod, cantInv, cantEmp, maxEmp, i : integer; monto, montoProm, maxInv : real;
begin
  cantEmp := 0;
  maxInv := -1;
  write('Código de empresa: '); read(cod);
  while (cod <> 100) do begin
    write('Inversiones: '); read(cantInv);
    montoProm := 0;
    for i:= 1 to cantInv do begin
      write(i,'° inversion: ' ); read(monto);
      montoProm := montoProm + monto;
    end;
    if (montoProm > maxInv) then maxEmp := cod;
    if (montoProm >= 50000) then cantEmp := cantEmp + 1;
    montoProm := montoProm / cantInv;
    writeln('Promedio de inversiones: ', montoProm:0:2);

    writeln;
    write('Código de empresa: '); read(cod);
  end;
  writeln('Empresa con mayor monto invertido: ', maxEmp);
  writeln('Hay ', cantEmp, ' empresas con inversiones mayores a $50000');
end.
