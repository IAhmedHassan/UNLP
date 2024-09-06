program ProgramaNumAleatorio;

var f,a,b,i, ale: integer;

begin
     randomize; {Elige una semilla distinta cada vez que se ejecuta el programa.}
                {La semilla sirve para generar series de números aleatorios distintos.}
                {Sin la llamada al procedimiento randomize, en todas las ejecuciones
                 del programa se elige siempre la misma serie de números aleatorios.}
    write('Ingrese valor de corte: ');
    readln(f);
    write('ingrese el rango: ');
    readln(a,b);
    i := 1;
    ale := random (b-a +1) + a; {devuelve un valor aleatorio en el intervalo 0 a 99}
    while ale <> F do begin
     writeln ('El ',i, '° numero aleatorio generado es: ', ale);
     ale := random (b-a +1) + a; {devuelve un valor aleatorio en el intervalo 0 a 99}
     i := i + 1;
    end; 
	 writeln (F,' encontrado. Presione cualquier tecla para finalizar');
     readln;
end.
