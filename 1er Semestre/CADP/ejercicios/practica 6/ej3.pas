program JugamosConListas;
type
  lista = ^nodo;
  nodo = record
    num : integer;
    sig : lista;
end;

procedure separador();
begin
  writeln('');
  writeln('------0------');
  writeln('');
end;

procedure armarNodo(var L: lista; v: integer);
var
  i, aux : lista;
begin
  i:= L;
  new(aux);
  aux^.num := v; aux^.sig := nil;
  {aux^.sig := L;
  L := aux;}
  if (i=nil) then L:=aux
  else begin
    while (i^.sig <> nil) do i:= i^.sig; 
    i^.sig:= aux;
  end;

end;


{ ejercicio C }
procedure imprimirLista(L: lista);
var act:lista;
begin
  act:= L;
  separador();
  write('lista:');
  while (act <> nil) do begin
    write(' ', act^.num);
    act := act^.sig;
  end; 

end;

procedure incrementar(L: lista; incr: integer);
var act:lista;
begin
  act:= L;
  writeln('incrementando en ', incr, '...');
  while (act <> nil) do begin
    act^.num:= act^.num + incr;
    act:= act^.sig;
  end;
  writeln('Incremento completado.');
end;

function maximo(L:lista): integer;
var m: integer;
begin
  m:= -maxInt;
  while(L <> nil) do begin
    if (L^.num > m) then m:= L^.num;
    L:= L^.sig;
  end;
  maximo := m;
end;

function minimo(L:lista): integer;
var m: integer;
begin
  m:= maxInt;
  while (L <> nil) do begin
    if (L^.num < m) then m:= L^.num;
    L:= L^.sig;
  end;
  minimo:= m;
end;

{programa principal}
var
  pri : lista;
  valor, max, min: integer;
  
  
begin
  pri := nil;
  write('Ingrese un numero: ');
  read(valor);
  while (valor <> 0) do begin
    armarNodo(pri, valor);
    write('Ingrese un numero: ');
    read(valor);
  end;
  imprimirLista(pri);
  separador(); 
  write('Ingrese un incremento: ');
  readln(valor);
  incrementar(pri,valor);
  imprimirLista(pri);
  separador();
  writeln('procedo a calcular maximo');
  max:= maximo(pri);
  min:= minimo(pri);
  writeln('maximo: ', max);
  writeln('minimo: ', min);


end.

{
  a. genera una pila de enteros distintos de 0,
  b. 0, 48, 13, 21, 10;
  c. 
}
