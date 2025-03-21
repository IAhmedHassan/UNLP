program ESA;
type
  espectro = 1..7;

  sonda = record
    nombre : string;
    meses : integer;
    costoConst : real;
    costoMant : real;
    estudio : espectro; 
  end;

  lista = ^nodo;

  nodo = record
    d : sonda;
    sig : lista;
  end;

  contSondas = array [espectro] of integer; 

procedure leerSonda(var s : sonda);
begin
  write('Nombre: '); readln(s.nombre);
  write('duración de la misión en meses: '); readln(s.meses);
  write('Costo de construcción: $'); readln(s.costoConst);
  write('Costo mensual de mantenimiento: $'); readln(s.costoMant);
  write('Rango de estudio: '); readln(s.estudio);
end;

procedure cargarLista(var L : lista; s : sonda);
var nue : lista;
begin
  new(nue);
  nue^.d := s;
  nue^.sig := nil;
  if (L = nil) then L := nue
  else begin
    nue^.sig := L;
    L := nue;
  end;
end;

procedure procesarLista(L : lista);

  procedure iniciarVCont(var v : contSondas);
  var i : espectro;
  begin
    for i := 1 to 7 do v[i] := 0;
  end;

  procedure informarVCont(v : contSondas);
  var i: espectro;
  begin
    for i := 1 to 7 do if (v[i] <> 0) then writeln(i,'. ', v[i]);
  end;

  procedure informarDuracionYCostoMayorDelPromedio(L : lista; cant, dTotal : integer; cTotal : real);
  var dProm : integer; cProm : real;
  begin
    dProm := dTotal div cant;
    cProm := cTotal / cant;
    writeln('Duración promedio: ', dProm);
    writeln('Costo de construcción promedio: $', cProm:0:2);
    writeln;
    while(L <> nil) do begin
      if (L^.d.costoConst > cProm) then writeln(L^.d.nombre, ' supera el costo de construcción promedio.');
      if (L^.d.meses > dProm) then writeln(L^.d.nombre,' supera la duración promedio.');
      L := L^.sig;
    end;
  end;


var maxCosto : real = -1; maxNom : string; costoSActual : real;
    cantSondas : integer = 0;  
    duracionTotal : integer = 0; costoTotal : real = 0;
    vCont : contSondas;
    aux : lista;
begin
  iniciarVCont(vCont);
  aux := L;
  while (L <> nil) do begin
    cantSondas := cantSondas + 1;
    duracionTotal := duracionTotal + L^.d.meses;
    costoSActual := L^.d.costoConst + L^.d.costoMant;
    costoTotal := costoTotal + L^.d.costoConst;
    if (costoSActual > maxCosto) then begin
      maxCosto := costoSActual; maxNom := L^.d.nombre;
    end;
    vCont[L^.d.estudio] := vCont[L^.d.estudio] + 1;
    L := L^.sig;
  end;
  writeln('La sonda más costosa es la ', maxNom);
  informarVCont(vCont);
  informarDuracionYCostoMayorDelPromedio(aux, cantSondas, duracionTotal, costoTotal);

end;

var s : sonda; L : lista = nil;
begin
  repeat
    leerSonda(s);
    cargarLista(L,s);
  until (s.nombre = 'GAIA');
  procesarLista(L);
end.