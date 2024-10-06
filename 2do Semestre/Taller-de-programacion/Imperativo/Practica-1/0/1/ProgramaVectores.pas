program ProgramaVectores;
const
	dimF = 50;
type
	vector = record
		arr: array[1..dimF] of integer;
		dimL : integer; 
	end;
procedure CargarVector(var v : vector; min, max, f : integer);
var rand, i : integer;
begin
	writeln('');
	i := 0;
	writeln('Generando vector.');
	randomize;
	rand := random(max - min +1) + min;
	while ((i < 50) and (rand <> f)) do begin
		i := i+1;
		v.arr[i] := rand;
		rand := random(max - min +1) + min;
	end;
	if i = dimF then writeln('Máximo de 50 alcanzado.') else 
	writeln(f, ' generado. Cantidad de valores generados: ', i);
	v.dimL := i;
end;

procedure ImprimirVector(v : vector);
var i : integer;
begin
	writeln('');
	writeln('Imprimiendo vector.');
	for i := 1 to v.dimL do begin
		if i=v.dimL then writeln(v.arr[i],'.')
		else write(v.arr[i], ', ');
	end;
end;

var v : vector; min, max, f : integer;
begin
	write('Ingrese mínimo y máximo: ');
	readln(min, max);
	write('Ingrese valor de corte: ');
	readln(f);
	CargarVector(v, min, max, f);
	ImprimirVector(v);
end.

