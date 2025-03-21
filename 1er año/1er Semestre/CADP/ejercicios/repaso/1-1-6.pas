program alumnos;
var legajo, cantEstudiantes, cantPromocion, cantDestacados, cantDestMin2500: integer;
    promedio: real;
begin
  cantEstudiantes := 0;
  cantDestacados := 0;
  cantPromocion := 0;
  cantDestMin2500 := 0;
  write('Legajo: '); read(legajo);
  while(legajo <> -1) do begin
    write('Promedio: '); read(promedio);
    cantEstudiantes := cantEstudiantes + 1;
    if (promedio >= 6.5) then begin
      if (promedio >= 8.5) then begin
        cantDestacados := cantDestacados + 1;
        if (legajo <= 2500) then cantDestMin2500 := cantDestMin2500 +1;
      end
      else cantPromocion := cantPromocion + 1
    end;
    writeln;
    write('Legajo: '); read(legajo);
  end;
  writeln('Alumnos: ', cantEstudiantes);
  writeln('Alumnos promocion: ', cantPromocion);
  writeln('Alumnos destacados: ', cantDestacados);
  writeln('Alumnos destacados legajo - 2500: ', cantDestMin2500);
  writeln('promedio destacados con legajo - 2500: %', (cantDestMin2500*100) / cantDestacados);

end. 