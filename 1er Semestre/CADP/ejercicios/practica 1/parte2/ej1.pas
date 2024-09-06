// Realizar un programa que lea 10 números enteros e informe la suma otal de los números leídos.
// a. Modifique el ejercicio 1 para que además informe la cantidad de números mayores a 5.

program ej1;
var a, total, i:integer;
begin
	total:=0;
	for i:= 1 to 10 do begin
		write('Ingrese el ',i,'er número: ');
		read(a);
		total:= total + a;
	end;
	writeln('El total de la suma de los 10 números ingresados es ',total);
end.
