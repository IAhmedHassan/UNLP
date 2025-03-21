program servicioDeTransporte;
const
  dimF = 200;
type
  dias = 1..31;

  viaje = record
    dia : dias;
    monto : real;
    km : integer;
  end;

  viajes = array[1..dimF] of viaje;

  vContador = array[dias] of integer;

  vViajes = record
    arr : viajes;
    dimL : integer;
  end;

procedure leerViaje(var e : viaje);
begin
  write('cantidad de kilómetros: '); readln(e.km);
  if (e.km <> 0) then begin
    write('Dia de viaje: '); readln(e.dia);
    write('monto transportado: '); readln(e.monto);
  end;    
end;

procedure cargarViaje(var v : vViajes; e : viaje);
begin
  if (v.dimL < 500) then begin
    v.dimL := v.dimL + 1;
    v.arr[v.dimL] := e;
  end else writeln('No se pudo cargar: memoria llena.');
end;

procedure initCont(var v : vContador);
var i : integer;
begin
  for i := 1 to 31 do v[i] := 0;
end;

procedure procesarViajes(v : vViajes);
var i : integer; promedio : real = 0; minE : viaje; vCont: vContador;
begin
  initCont(vCont);
  minE.monto := MaxInt;
  for i := 1 to v.dimL do begin
    vCont[v.arr[i].dia] := vCont[v.arr[i].dia] + 1;
    if (v.arr[i].monto < minE.monto) then minE := v.arr[i];
    promedio := promedio + v.arr[i].monto;
  end;
  promedio := promedio / v.dimL;
  writeln('Monto promedio por viaje: ', promedio:0:2);
  writeln('El día que se transportó menos dinero fue el ', minE.dia,', cuando se transportaron $',minE.monto:0:2,' por ', minE.km,' kms.' );
  writeln('Cantidad de viajes por día: ');
  for i:=1 to 31 do if (vCont[i] > 0) then writeln(i,': ', vCont[i]);
end;

procedure borrarViaje(var v : vViajes; n : integer);
var i : integer;
begin
  v.dimL := v.dimL - 1;
  for i := n to v.dimL do v.arr[i] := v.arr[i + 1];
end;

procedure limpiarMenosDe100(var v : vViajes);
var i : integer;
begin
  writeln('---LIMPIANDO VIAJES DE 100 KM ---');
  for i := 1 to v.dimL do begin
    if v.arr[i].km = 100 then begin 
      borrarViaje(v,i);
      writeln('entrada ', i,' borrada.'); 
    end;
  end;
end;

var v : vViajes; e : viaje;
begin
  v.dimL := 0;
  writeln('--- LECTURA DE VIAJES ---');
  leerViaje(e);
  while((e.km <> 0) and (v.dimL < dimF)) do begin
    cargarViaje(v,e);
    leerViaje(e);
  end;
  writeln('--- PROCESAMIENTO de VECTOR ---');
  procesarViajes(v);
  limpiarMenosDe100(v);
end.