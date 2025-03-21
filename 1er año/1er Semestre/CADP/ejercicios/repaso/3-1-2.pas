program casamientos;
type
  fecha = record
    dia : integer;
    mes : integer;
    anio : integer;
  end;
  meses = array[1..12] of integer;

procedure leerfecha(var a : fecha);
begin
  write('Ingrese año: '); read(a.anio);
  if (a.anio < 2020) then begin
  write('Ingrese mes: '); read(a.mes);
  write('Ingrese dia: '); read(a.dia);
  end;
end;

procedure iniciarVector(var v : meses);
var i : integer;
begin
  for i := 1 to 12 do v[i] := 0;
end;

procedure escribirAPorMes(v : meses);
var i : integer;
begin
  writeln('casamientos en los primeros dias de cada mes: ');
  for i:= 1 to 12 do writeln(i,': ', v[i]);
end;


var a : fecha; aPorMes: meses; aEnVerano : integer = 0;
begin
  iniciarVector(aPorMes);
  leerfecha(a);
  while(a.anio <> 2020) do begin
    if (a.mes <= 3 ) then aEnVerano := aEnVerano + 1;
    if (a.dia <= 10) then aPorMes[a.mes] := aPorMes[a.mes] + 1;
    leerfecha(a);
  end;
  writeln('Casamientos en verano: ', aEnVerano);
  escribirAPorMes(aPorMes);
end.
