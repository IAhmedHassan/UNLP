program Ejercicio9;

  procedure calcularMinimos(
    var minApellido1, minApellido2: string;
    aluApellido: string,
    var minInscripcion1, minInscripcion2: integer;
    aluInscripcion: integer );
  begin

    if (aluInscripcion < minInscripcion2)
    then begin

      if (aluInscripcion < minInscripción1) then
        begin
          minInscripcion2:= minInscripcion1; minApellido2:= minApellido1;
          minInscripcion1:= aluInscripcion; minApellido1:= aluApellido;
        end;

    else begin
      minInscripcion2:= aluInscripcion; minApellido2:= aluApellido;

    end;
  end;

var nombre, nomMax1, nomMax2, apellido, apMin1, apMin2: string;
    i, inscripcion,  

begin
  
end.