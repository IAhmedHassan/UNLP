program recursividad;
const dimF = 15;
type
  arreglo = array [1..dimF] of integer;
  
  vector = record
    arr : arreglo;
    dimL : integer;
  end;


{///////////////////--PUNTO-A--/////////////////////}

procedure initVector (var v : vector);

  procedure cargarRecursivo (var v : vector);
  var rand : integer;
  begin
    rand := random(155 - 10 +1) +10;
    if ((rand <> 20) and (v.dimL < dimF)) then begin
      v.dimL := v.dimL +1;
      v.arr[v.dimL] := rand;
      cargarRecursivo(v);
    end;
  end;
  
begin
  v.dimL := 0;
  writeln;
  writeln('Cargando vector...');
  writeln;
  cargarRecursivo(v);
end;

{/////////////////////--PUNTO-B--///////////////////////}

procedure imprimir (v : vector);
var i : integer;
begin
  writeln;
  writeln('Imprimir: ');
  for i := 1 to v.dimL do begin
    if (i = v.dimL) 
      then writeln(v.arr[i], '.')
      else write(v.arr[i], ', ');
  end;
end;

{/////////////////////--PUNTO-C--//////////////////////////}

procedure imprimirR(v : vector);

  procedure imprimirRecursivo(v : vector; i : integer);
  begin
    if i <= v.dimL then begin
      write(v.arr[i], ', ');
      imprimirRecursivo(v, i +1);
    end;
  end;

var i : integer = 1;
begin
  writeln;
  writeln('imprimirR: ');
  imprimirRecursivo(v, i);
  writeln('.');
end;

{/////////////////////--PUNTO-D--///////////////////////////////////}

function SumaTotalPares(v : vector): integer;

  function sumaRecursivo(v : vector; i : integer): integer;
  begin
    if i > v.dimL then sumaRecursivo := 0
    else begin
      if v.arr[i] mod 2 = 0
        then sumaRecursivo := sumaRecursivo(v, i+1)
        else sumaRecursivo := sumaRecursivo(v, i+1) + v.arr[i]
    end;
  end;

var i : integer = 1;
begin
  SumaTotalPares := sumaRecursivo(v, i);
end;

{////////////--PUNTO-E--//////////////////////////////////////}

function buscarMax(v : vector): integer;

  function maximoRecursivo(v : vector; i, max : integer): integer;
  begin
    if i > v.dimL then maximoRecursivo := max
    else begin
      if v.arr[i] > max 
        then maximoRecursivo := maximoRecursivo(v, i+1, v.arr[i])
        else maximoRecursivo := maximoRecursivo(v, i+1, max)
    end;
  end;

var 
  i : integer = 1; 
  max : integer = 9;
begin
  buscarMax := maximoRecursivo(v, i, max);
end;

{/////////////--PUNTO-F--////////////////////}

function estaEnElVector(v : vector; num : integer): boolean;

  function buscarRecursivo(v : vector; estado : boolean; i : integer): boolean;
  begin
    if  i > v.dimL then buscarRecursivo:= false
    else begin
      if ((v.arr[i] = num))
        then buscarRecursivo := true
        else buscarRecursivo := buscarRecursivo(v, estado, i+1)
    end;
  end;

var 
  estado : boolean = false;
  i : integer = 1;
begin
  estaEnElVector := buscarRecursivo(v, estado, i);
 end;

{////////////--PRINCIPAL--//////////////}
var 
  v : vector; 
  totalV, valorMaximo, num : integer;
  
begin
  randomize;
  initVector(v);
  imprimir(v);
  imprimirR(v);
  totalV := SumaTotalPares(v);
  writeln('Suma total del vector: ', totalV);
  valorMaximo := buscarMax(V);
  writeln('Numero Máximo del vector: ', valorMaximo);
  write('Ingrese un valor: '); readln(num);
  if estaEnElVector(v, num)
    then writeln('El num ', num, ' está en el vector.')
    else writeln('El num ', num, ' no está en el vector.')
end.
