program Ej3;

uses Crt, SysUtils;

type
  Empleado = record
    idEmp : integer;
    apellido : string;
    nombre : string;
    edad : integer;
    DNI : longInt;
  end;

  archivo = file of Empleado;

  procedure leerEmpleado(var e : Empleado);
  begin
    write('Apellido (fin para terminar): '); readln(e.apellido);
    if not (e.apellido = 'fin') then begin
      write('Nombre: '); readln(e.nombre);
      write('Edad: '); readln(e.edad);
      write('DNI: '); readln(e.DNI);
      write('ID: '); readln(e.idEmp);
    end;

  end;

  function eToString(e : Empleado) : string;
  begin
    eToString := IntToStr(e.idEmp) + ' | ' + e.nombre + ' ' + e.apellido + ' | ' + IntToStr(e.edad) + ' años | ' + IntToStr(e.DNI);
  end;

  procedure cargarArchivo(var ef : archivo);
  var  e : Empleado;
  begin
    rewrite(ef);
    leerEmpleado(e);
    while(e.apellido <> 'fin') do begin
      write(ef, e);
      leerEmpleado(e);
    end;
    close(ef);
  end;

  procedure listarEmpleados(var ef : archivo);
  var e : Empleado;
  begin
    reset(ef);
    while not EOF(ef) do begin
      read(ef,e);
      writeln(eToString(e));
    end;
    close(ef);
  end;

  procedure buscarEmpleado(var ef : archivo);
  var buscar : string; e : Empleado; Encontrado : boolean = false;
  begin
    write('Nombre o apellido a buscar: '); readln(buscar);
    reset(ef);

    while not EOF(ef) do begin
      read(ef, e);
      if ((e.nombre = buscar) or (e.apellido = buscar)) then begin
        writeln(eToString(e));
        Encontrado := true;
      end;
    end;

    if not Encontrado then writeln('No hay coincidencias.');
    close(ef);
  end;

  procedure porJubilarse(var ef : archivo);
  var e : Empleado;
  begin
    reset(ef);
    writeln('Empleados por jubilarse: ');
    while not EOF(ef) do begin
      read(ef, e);
      if ( e.edad >= 70 ) then writeln(eToString(e)); 
    end;
    close(ef);
  end;

  procedure aniadirEmpleados(var ef : archivo);
  var e : Empleado;
  begin
    {if not (FileSize(ef) = 0) then} 
    reset(ef);
    { else rewrite(ef); }
    seek(ef,FileSize(ef));
    leerEmpleado(e);
    while(e.apellido <> 'fin') do begin
      write(ef, e);
      leerEmpleado(e);
    end;
    close(ef);
  end;

  procedure modificarEdadEmpleados(var ef : archivo);
  var e : Empleado; id : integer;
  begin
    reset(ef);
    write('ID del empleado (-1 para salir): '); readln(id);
    while (id <> -1) do begin
      while not EOF(ef) do begin
        read(ef,e);
        if (e.idEmp = id) then begin
          writeln(eToString(e));
          write('nueva edad: '); readln(e.edad);
          seek(ef, FilePos(ef) - 1);
          write(ef,e);
        end;
      end;
      write('ID del empleado (-1 para salir): '); readln(id);
    end;
    close(ef);
  end;

  procedure exportarLista(var ef : archivo);
  var e : Empleado; et : Text; eString : string;
  begin
    assign(et, 'todos_empleados.txt');
    reset(ef);
    rewrite(et);
    while not EOF(ef) do begin
      read(ef,e);
      eString := eToString(e); 
      writeln(et,eString);
    end;
    close(ef);
    close(et);
  end;

  procedure exportarSinDNI(var ef : archivo);
  var e : Empleado; et : Text; eString : string;
  begin
    assign(et, 'faltaDNIEmpleado.txt');
    reset(ef);
    rewrite(et);
    while not EOF(ef) do begin
      read(ef,e);     
      if (e.DNI = 0) then begin
        eString := eToString(e); 
        writeln(et, eString);
      end;
    end;
    close(ef);
    close(et);
  end;

  procedure baja(var ef : archivo);
  var ult, e : Empleado; id : integer;
  begin
    reset(ef);
    write('Ingrese el ID del empleado a borrar: '); readln(id);
    seek(ef, FileSize(ef) - 1);
    read(ef, ult);
    seek(ef, 0);
    read(ef, e);
    while((not EOF(ef)) and (e.idEmp <> id)) do read(ef, e);
    if (e.idEmp = id) 
      then begin
        seek(ef, FilePos(ef) - 1);
        write(ef, ult);
        seek(ef, FileSize(ef) - 1);
        truncate(ef);
      end
      else writeln('No existe empleado con ID ', id, '.');
    close(ef);
  end;

var
  opcion : integer;
  ef : archivo;
  nomArchivo : string;

begin
  write('Nombre del archivo: '); readln(nomArchivo);
  assign(ef, nomArchivo);
  
  repeat
    writeln;
    writeln;
    write('Presione cualquier tecla para volver al menú...');
    ReadKey; // Pausa antes de regresar al menú
    ClrScr;
    writeln('1: Cargar Archivo');
    writeln('2: Listar Empleados');
    writeln('3: Buscar un empleado');
    writeln('4: Listar empleados por jubilarse');
    writeln('5: Añadir empleados');
    writeln('6: Modificar edad de empleados');
    writeln('7: Exportar lista de empleados');
    writeln('8: Exportar empleados sin DNI');
    writeln('9. Eliminar un empleado');
    writeln('0: Salir');

    write('Seleccione una opción: '); readln(opcion);
    writeln; writeln;
    case opcion of
      1: cargarArchivo(ef);
      2: listarEmpleados(ef);
      3: buscarEmpleado(ef);
      4: porJubilarse(ef);
      5: aniadirEmpleados(ef);
      6: modificarEdadEmpleados(ef);
      7: exportarLista(ef);
      8: exportarSinDNI(ef);
      9: baja(ef);
      0: writeln('Saliendo.');
      else writeln('No es una opción válida.');
    end;
  until (opcion = 0);
end.
