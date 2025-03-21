program estaNEnVector;
type
  rangoV = 1..501;
  enteros500 = Array[rangoV] of integer;

procedure inicializar(var v : enteros500; var dimL : rangoV);
var i: rangoV = 1; num : integer;
begin
  randomize; 
  num := random(50);
  while ((num <> 0) and (i <= 500)) do begin
    v[i] := num;
    write(v[i], ', ');
    i := i + 1;
    num := random(50);
  end;
  dimL := i - 1;
  writeln;
  writeln('dimL := ', dimL);
end;

function buscarNEn(v : enteros500; n : integer; dimL : rangoV): boolean;
var i : rangoV = 1; b : boolean = false;
begin
  while ((not b) and (i <= 500)) do begin
    if (v[i] = n) then begin
      b := true;
      writeln(n,' está en la posicion ', i, ' que contiene ', v[i]);
    end;
    i := i + 1;
  end; 
  buscarNEn := b;
end;

var v : enteros500; dimL: rangoV; n : integer; esta : boolean;
begin
  inicializar(v, dimL);
  write('ingrese un numero: '); read(n);
  esta := buscarNEn(v,n,dimL);
  if (esta) then write(n, ' está en el vector.')
  else write(n, ' no está en el vector.');
end.