program inventarioLibreria;
type
  producto = record
    cod : integer;
    rubro : integer;
    precio : real;
  end;
  
  lista = ^nodo;

  nodo = record
    prod : producto;
    sig : lista;
  end;
  
  vector = array [1..8] of lista;
  vectorProd = array [1..30] of producto;

procedure inicializarVectores(var v : vector);
var i : integer;
begin
  for i := 1 to 8 do begin
    v[i] := nil;
  end;
end;

procedure insertar(var L : lista; nuevo : producto);
var i, aux : lista;
begin
  new(aux); aux^.prod := nuevo; aux^.sig := nil;
  if (L = nil) then begin L := aux; end
  else begin
    i := L;
    while i^.sig <> nil do begin
      i := i^.sig;
    end;
    i^.sig := aux;
  end;
end;

procedure cargarProductos(var v : vector);
var nuevo : producto;
begin
  write('Ingrese el código del producto: '); readln(nuevo.cod);
  while (nuevo.cod <> 0) do begin
    write('Ingrese el rubro (del 1 al 8): '); readln(nuevo.rubro);
    write('Ingrese el precio: $'); readln(nuevo.precio);
    insertar(v[nuevo.rubro], nuevo);
    write('Ingrese el código del producto: '); readln(nuevo.cod);
  end;
  writeln(nuevo.cod,' ', nuevo.rubro, ' ', nuevo.precio);
end;

procedure leerRubro(L : lista);
begin
  while L <> nil do begin
    write(L^.prod.cod,', ');
    L := L^.sig;
  end;
  writeln('fin.');
end;

procedure productosPorRubro(v : vector);
var i : integer;
begin 
  for i := 1 to 8 do begin
    write(i, '° rubro: ');
    leerRubro(v[i]);
  end;
end;

procedure leerVector(v : vectorProd; dimL : integer);
var i : integer;
begin
  for i := 1 to dimL do begin
      writeln('producto: ',v[i].cod);
      writeln('rubro: ', v[i].rubro);
      writeln('precio: $', v[i].precio:0:2);
      writeln;
  end;
end;


procedure productosRubro3(L : lista; var vP : vectorProd; var dimL : integer; var band : boolean);
var i : integer = 0;
begin
  if L = nil then begin writeln('No hay productos del rubro 3.'); band := TRUE; end
  else begin
    repeat
      i := i + 1;
      vP[i].cod := L^.prod.cod;
      vP[i].precio := L^.prod.precio;
      L := L^.sig;
    until ((L = nil) OR (i >= 30));
    dimL := i;
  end;
end;

procedure ordenarVector(var vp : vectorProd; dimL : integer);
var i,j : integer; actual : producto;
begin
  writeln('Ordenando vector...');
  writeln;
  for i := 2 to dimL do begin
    actual := vp[i];
    j := i-1;
    while (j > 0) AND (vp[j].precio > actual.precio) do begin
      vp[j+1] := vp[j];
      j := j - 1;
    end;
    vp[j + 1] := actual;
  end;
end;

procedure PreciosyPromedio(var v : vectorProd; dimL : integer; band : boolean );
var i: integer; total: real = 0; promedio: real = 0;
begin
  if band then begin writeln('F'); end
  else begin
    for i := 1 to dimL do begin
      writeln('producto: ',v[i].cod);
      writeln('precio: $', v[i].precio:0:2);
      writeln;
      total := total + v[i].precio;
    end;
    promedio := total / dimL;
    writeln('Precio promedio producto rubro 3: $', promedio:0:2);
  end;
end;

var v : vector; vP : vectorProd; vP_dimL : integer; band : boolean = FALSE;
begin
  inicializarVectores(v);
  cargarProductos(v);
  productosPorRubro(v);
  productosRubro3(v[3], vP, vP_dimL, band);
  leerVector(vP, vP_dimL);
  ordenarVector(vP, vP_dimL);
  PreciosyPromedio(vP, vP_dimL, band);
end.
