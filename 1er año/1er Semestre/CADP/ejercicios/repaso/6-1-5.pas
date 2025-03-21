program Supermercado;
type
  producto = record
    cod : integer;
    descripcion : string;
    stockActual: integer;
    stockMinimo : integer;
    precio : real;
  end;

  lista = ^nodo;

  nodo = record
    dato : producto;
    sig : lista;
  end;


procedure leerProducto(var p : producto);
begin
  write('Código de producto: '); readln(p.cod);
  if (p.cod <> -1) then begin
    write('Descripción: '); readln(p.descripcion);
    write('Precio: '); readln(p.precio);
    write('Stock Mínimo: '); readln(p.stockMinimo);
    write('Stock Actual: '); readln(p.stockActual);
  end;
end;

procedure cargarProducto(var p : producto; var L : lista);
var n: lista;
begin
  new(n);
  n^.dato := p;
  n^.sig := nil;
  if (L = nil) then L := n
  else begin
    n^.sig := L^.sig;
    L := n;
  end; 
end;

function codCon3Pares(cod : integer): boolean;
var bool : boolean = false; resto : integer; cantPares : integer = 0;
begin
  while((cod > 0) and (not bool)) do begin
    resto := cod mod 10;
    if ((resto mod 2) = 0) then begin
      cantPares := cantPares + 1;
      if cantPares = 3 then bool := true;
    end;
    cod := cod div 10;
  end;
  codCon3Pares := bool;
end;

procedure procesarLista(L : lista);
var prom : real; prods : integer = 0 ; prodsPaReponer : integer = 0; min1, min2: producto;
begin
  min1.precio := MaxInt;
  min2.precio := MaxInt;
  while (L <> nil) do begin
    prods := prods + 1;
    if (L^.dato.stockActual < L^.dato.stockMinimo) then 
      prodsPaReponer := prodsPaReponer + 1;
    if (codCon3Pares(L^.dato.cod)) then writeln('producto ', L^.dato.cod, ': ', L^.dato.descripcion);
    if (L^.dato.precio < min1.precio) then begin
      min2 := min1;
      min1 := L^.dato;
    end 
    else if (L^.dato.precio < min2.precio) then min2 := L^.dato;
    L := L^.sig;
  end; 
  prom := prodsPaReponer / prods;
  writeln('Porcentaje de productos a reponer: ', prom:0:2);
  writeln('Productos mśa económicos:');
  writeln('1. ', min1.cod, ' - ', min1.descripcion);
  writeln('2. ', min2.cod, ' - ', min2.descripcion);

end;

var L : lista; p : producto;
begin
  L := nil;
  writeln('--- LECTURA PRODUCTOS ---');
  leerProducto(p);
  while (p.cod <> -1) do begin
    cargarProducto(p,L);
    writeln('------');
    leerProducto(p);
  end;
  procesarLista(L);
end.