program test;
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

var i,cant : integer; productos : producto;
begin
  randomize;
  for i:= 1 to 32 do begin
    productos.cod := i;
    productos.rubro := {random(8)} 3;
    productos.precio := random(100);
    writeln(productos.cod);
    writeln(productos.rubro);
    writeln(productos.precio:0:2);
  end;
  writeln(0);
end.
