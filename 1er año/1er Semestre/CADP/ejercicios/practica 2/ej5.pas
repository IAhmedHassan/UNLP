program Ejercicio5;
	function esDoble(numA, numB : integer): boolean;
		begin
			esDoble:= ((numB - numA) = numA);
    end;
var numA, numB, cantLeidos, cantDobles : integer;
begin
	cantDobles:= 0;
	cantLeidos:= 0;
	writeln('');
	writeln('--------------------------------');
	writeln('');
	writeln('Programa para contar pares de números y dobles');
	
	write('Ingrese un par de números: ');
	read(numA, numB);
	while ((numA <> 0) and (numB <> 0)) do begin
		if (esDoble(numA, numB)) then cantDobles:= cantDobles +1;
		cantLeidos:= cantLeidos +1;
		write('Ingrese otro par de números: ');
		read(numA, numB);
	end;
	writeln('Cantidad de pares leídos: ', cantLeidos);
	writeln('Cantidad de pares dobles leídos: ', cantDobles);
	
end.