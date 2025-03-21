program finales;
type
  tfecha = record
    dia : integer;
    mes : integer;
    año : integer;
  end;

  final = record
    legajo : integer;
    codMateria : integer;
    fecha : tfecha;
    nota : real;
  end;

  lista_alumnos = ^nodolista;
  nodolista = record
    dato : final;
    sig : lista_alumnos;
  end;

  arbol = ^nodoarbol;
  nodoarbol = record
    dato : final;
    HI : arbol;
    HD : arbol;
  end;

procedure leerFinales(a : arbol);
  procedure tieneLista()
  procedure cargarFinalLista(var L : lista_alumnos; f : final);
  begin
    while L <> nil do begin


  procedure cargarFinalArbol(var a : arbol; f : final );
  begin
    if a = nil 
      then begin
        new(a);
        a^.dato := f;
        a^.HI := nil;
        a^.HD := nil;
      else begin
        if f.legajo < a^.dato.legajo 
          then cargarFinal(a^.HI, f);
          else cargarFinal(a^.HD, f);
  end;

var nue : final;
begin
  write('Legajo: '); readln(nue.legajo);
  while nue.legajo <> 0 do begin
    write('Código de materia: '); readln(nue.codMateria);
    write('fecha: '); readln(nue.fecha.dia, nue.fecha.mes, nue.fecha.año);
    write('notda: '); readln(nue.nota);
    cargarFinalArbol(a,nue);
    cargarFinalLista(f,nue);
end;


var a : arbol; L : lista_alumnos;
begin
  leerFinales(a, L);
end.
