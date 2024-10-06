program aerolineasArgentinas;
type 
  pasaje = record
    vuelo : integer;
    cliente : integer;
    destino : integer;
    monto : real;
  end;

  nodoL = record
    dato : pasaje;
    sig : listaPasajes;
  end;

  listaPasajes = ^nodoL;
  
  nodoA = record
    ciudad : integer;
    pasajes : listaPasajes;
    HI : arbol;
    HD : arbol;

  arbol = ^nodoA;

procedure cargarEnLista(L : listaPasajes; p : pasaje);
var nue : listaPasajes;
begin
  new(nue); nue^.dato := p; nue^.sig := nil;
  if L = nil 
    then L := nue
    else begin
      nue^.sig := L;
      L := nue;
    end
end;

procedure cargarElemento(a : arbol; p : pasaje);
begin
  if a = nil
    then begin
      new(a);
      a^.ciudad := p.destino;
      cargarEnLista(a^.pasajes, p):
      a^.HI := nil;
      a^.HD := nil;
    end
    else
      if a^.ciudad = p.destino then cargarEnLista(a^.pasajes, p)
      else begin
        if p.destino > a^.ciudad then cargarElemento(a^.HD, p)
        else cargarElemento(a^.HI, p)
end;

procedure leerPasaje(a : arbol);
var p : pasaje; d : integer;
begin
  write('Monto: '); readln(p.monto);
  if p.monto <> 0 then begin
    write('Vuelo: '); readln(p.vuelo);
    write('Destino: '); readln(p.destino);
    write('Cliente: '); readln(p.cliente);
  end;
end;

procedure imprimirListaPasajes(L : listaPasajes);
begin
  while L <> nil do begin
    writeln;
    writeln('Vuelo: ', L^.dato.vuelo);
    writeln('Cliente: ', L^.dato.cliente);
    writeln('Monto: ', L^.dato.monto:0:2);
    writeln;
    L := L^.sig;
end;

procedure cargarArbol(a: arbol);
var p : pasaje;
begin
  leerPasaje(p);
  while p.monto <> 0 do begin
    cargarElemento(a,p);
    leerPasaje(p);
end;

procedure verCiudad(a);

  procedure buscarCiudad(a: arbol; ciudad : integer);
  begin
    if a <> nil then begin
      if a^.ciudad = ciudad then imprimirListaPasajes(a^.pasajes);
      else begin 
        if ciudad < a^.ciudad 
          then buscarCiudad(a^.HI, ciudad)
          else buscarCiudad(a^.HD, ciudad)
      end
    end
  end;

var ciudad : integer;
begin
  write('Ingrese el código de la ciudad: '); readln(ciudad);
  buscarCiudad(a, ciudad);

end;


var a : arbol;
begin
  cargarArbol(a);
  verCiudad(a);
end.
