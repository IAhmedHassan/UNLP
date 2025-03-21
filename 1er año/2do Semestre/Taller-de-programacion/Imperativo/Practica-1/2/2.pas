program adminExpensas;
const dimF = 300;
type
  oficina = record
    cod : integer;
    DNI : longint;
    expensas : real;
  end;

  oficinas = array [1..dimF] of oficina;

procedure generarVector(var v : oficinas; var dimL : integer);
var aux : oficina; i: integer;
begin
  i := 1;
  dimL := i;
  write('Ingrese código de oficina: '); readln(aux.cod);
  while ((aux.cod <> -1) AND (dimL <= dimF)) do begin
    write('Ingres DNI del propietario: '); readln(aux.DNI);
    write('Ingrese total de las expensas: '); readln(aux.expensas);
    writeln;
    v[i] := aux;
    dimL := i;
    i := i+1;
    write('Ingrese código de oficina: '); readln(aux.cod);
  end;
end;

procedure insercionV(var v : oficinas; dimL : integer);
var i, j: integer; actual : oficina;
begin
  for i := 2 to dimL do begin
    actual := v[i];
    j := i-1;
    while ((j > 0) AND (v[j].cod > actual.cod)) do begin
      v[j+1] := v[j];
      j := j - 1;
    end;
    v[j+1] := actual;
  end;
end;

procedure seleccionV(var v: oficinas; dimL : integer);
var i, j, pos : integer; actual : oficina;
begin
  for i := 1 to dimL-1 do begin
    pos := i;
    for j := i+1 to dimL do begin
      if (v[j].cod < v[pos].cod) then begin pos := j; end;
    end;
    actual := v[pos];
    v[pos] := v[i];
    v[i] := actual;
  end;
end;


procedure mostrarV(v : oficinas; dimL : integer);
var i : integer;
begin
  for i := 1 to dimL do begin
    writeln(i,'.');
    writeln('Codigo: ', v[i].cod);
    writeln('DNI dueño: ', v[i].DNI);
    writeln('Total expensas: $', v[i].expensas);
    writeln;
  end;
end;


var vof : oficinas; dimL : integer; entry : integer;

begin
  writeln('--- GENERANDO VECTOR ---');
  writeln;
  generarVector(vof, dimL);
  writeln;
  writeln('--- FIN GENERACION ---');
  writeln;
  writeln('1. insercion; 2. selección'); readln(entry);
  if entry = 1 then begin 
    write('---INSERCION ---');
    insercionV(vof, dimL);
  end
  else begin
    write('--- SELECCION ---');
    seleccionV(vof, dimL);
  end;
  mostrarV(vof, dimL);
end.
