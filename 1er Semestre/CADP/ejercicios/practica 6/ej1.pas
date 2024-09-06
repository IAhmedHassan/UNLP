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
  aux : lista;
begin
  new(aux);
  aux^.num := v;
  aux^.sig := L;
  L := aux;
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

var
  pri : lista;
  valor : integer;
  
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
end.

{
  a. genera una pila de enteros distintos de 0,
  b. 0, 48, 13, 21, 10;
  c. 
}
