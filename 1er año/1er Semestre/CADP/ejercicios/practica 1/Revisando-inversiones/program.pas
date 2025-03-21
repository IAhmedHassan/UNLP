// Realizar un programa que analice las inversiones de las empresas más grandes del país. Para cada empresa se lee su código (un número entero), la cantidad de inversiones que tiene, y el monto dedicado a cada una de las inversiones. La lectura finaliza al ingresar la empresa con código 100, que debe procesarse. El programa deberá informar:
// ● Para cada empresa, el monto promedio de sus inversiones
// ● Código de la empresa con mayor monto total invertido
// ● Cantidad de empresas con inversiones de más de $50000

program RevisandoInversiones;
type
  empresa = Record
    codEmpresa : integer;
    inversiones : integer;
    montoInversiones : real;
  end;

  lista = ^nodo;

  nodo = Record
    dato : empresa;
    sig : lista;
  end;

procedure armarNodo(var L : lista; e : empresa);
var
  aux : lista;
begin
  new(aux);
  aux^.dato := e;
  aux^.sig := L;
  L := aux;
end;

procedure procesarNodo(e : empresa);
begin

end;

procedure recorrerLista(L : lista);
begin
  while (L != nil) do begin
    procesarNodo(l.dato);
    L := L.sig;
  end;
end;

procedure leerEmpresa(var e : empresa);
begin
  write('Ingrese el código de la Empresa: ');
  read(e.codEmpresa);
  while(e.codEmpresa <> 100) do begin
    write('ingrese la cantidad de inversiones');
    read(e.inversiones);
    write('Cuál es el monto de cada inversión?');
    read(e.montoInversiones);
   
    read(e.codEmpresa);
  end;
end;

var
  L : lista; e : empresa;
begin
  writeln('');
  writeln('------------------------------------');
  writeln('Programa de inversiones de empresas.');
  writeln('');
  leerEmpresa(e);
  armarNodo(L,e);
end.
