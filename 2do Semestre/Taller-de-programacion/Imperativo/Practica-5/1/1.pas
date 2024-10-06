program Expensas;
const dimF = 300;

type documento = string[8];
  oficina = record
    cod : integer;
    DNI : documento;
    expensas : real;
  end;

  vecOfic = record
    arr : array [1..dimF] of oficina;
    dimL : integer;

procedure initVec(v : vecOfic);
var nuevo : oficina;

begin
  v.dimL := 1;
  write('Ingrese código de oficina: '); readln(nuevo.cod);
  while (cod <> 0 and v.dimL <= dimF) do begin
    write('Ingrese DNI del propietario: '); readln(nuevo.DNI);
    write('Ingrese valorf de las expensas: '); readln(nuevo.expensas);
    v.arr[i] := nuevo;
    v.dimL := v.dimL + 1
    write('Ingrese código de oficina: '); readln(nuevo.cod);
  end;
end;

procedure ordenarVector(v : vecOfic);
var i, j : integer; aux : oficina;
begin
  for i := 2 to v.dimL do begin
    j := i-1;
    aux := v.arr[i];
    while ((j > 0) AND (v.arr[j].cod > aux.cod)) do begin
      v.arr[j + 1] := v.arr[j];
      j := j-1;
    end;
    v.arr[j + 1] := aux;
end;

function busquedaDicotomica(v : vecOfic; codABuscar : integer);

var i, max, min : integer;
begin
  while codABuscar <> v.arr[i].cod AND i <> 0 do begin
    max := v.dimL;
    min := 1;
    i := (min + max) DIV 2;
    if (v.arr[i] < codABuscar) then max := i else min := i;
  end;
  busquedaDicotomica := i;
end;

var v : vecOfic; codABuscar : integer;
begin
  initVec(v);
  ordenarVector(v);
  write('Ingrese un código de oficina para buscar: '); readln(codABuscar);
  if busquedaDicotomica(v,codABuscar) = 0 
    then writeln('No se encontró la oficina.')
    else writeln('DNI propietario: ', v.arr[])
end.
