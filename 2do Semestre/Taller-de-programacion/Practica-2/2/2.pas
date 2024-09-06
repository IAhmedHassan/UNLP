HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA


program recursividad;
type
  lista = ^nodo;

  nodo = record
    dato : integer;
    sig : lista;
  end;


procedure generarEnterosR ( var L: lista);
var rand : integer; nue: lista;
begin
  rand := random(200 - 100 + 1) +100;
  if (rand <> 100) then
    new(nue); nue^.dato := rand;
    L := nue;
    generarEnterosR(L^.sig);
  else L^.sig := nil;
end;

procedure imprimirListaR( L : lista);
var
begin
  if L <> nil then begin
    writeln(L^.dato);
    imprimirListaR(L^.sig);
  end;
end;

procedure imprimirListaInversoR(L : lista);
begin
  if L <> nil then begin
    imprimirListaInversoR(L^.sig);
    writeln(L^.dato);
  end;
end;

function minimo(L : lista): integer;

  function minimoR(L : lista; min : integer): integer;
  begin
    if L = nil then
      minimoR := min;
    else begin
      if min <= L^.dato 
        then minimoR := minimoR(L^.sig, min);
        else minimoR := minimoR(L^.sig, L^.dato);
      end;
    end;
  end;

var min : integer := 9999;
begin
  minimo := minimoR(L, min);
end;

function estaEnLaLista(L : lista; num : integer): boolean;
begin
  if L <> nil
    then estaEnLaLista := FALSE;
    else if 
end;

var L : lista; min, num : integer; bool: boolean;
begin
  randomize;
  generarEnterosR(L);
  imprimirListaR(L);
  imprimirListaInversoR(L);
  min := minimo(L);
  write('Ingrese un numero entre 100 y 200: '); readln(num);
  if (estaEnLaLista(L,num)) 
    then writeln(num, ' está en la lista. :D');
    else writeln(num, ' no está en la lista. :c'); 
  end;
end.
