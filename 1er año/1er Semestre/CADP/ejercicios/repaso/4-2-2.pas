program alumnosEnVector;
type
  nombre = string;
  vAlumnos = array[1..500] of nombre;

  arregloAlumnos = record
    v : vAlumnos;
    dimL : integer;
  end;

procedure cargarAlumno(var v : arregloAlumnos; a : nombre);
begin
  if(v.dimL < 500) then begin
  v.dimL := v.dimL + 1;
  v.v[v.dimL] := a;
  writeln('alumno cargado correctamente. dimL: ', v.dimL);
  end
  else write('.');
end;

procedure eliminarDeVector(var v : arregloAlumnos; n : integer);
var i : integer;
begin
  for i:= n to (v.dimL - 1) do v.v[i] := v.v[i+1];
  v.dimL := v.dimL - 1;
end;

procedure eliminarAlumno(var v : arregloAlumnos);
var i : integer = 1; encontrado : boolean = false; a : nombre;
begin
  writeln('--- ELIMINAR ALUMNO ---');
  write('Ingrese un nombre: '); readln(a);
  while ((i <= v.dimL) and (not encontrado)) do begin
    if (v.v[i] = a) then begin
      eliminarDeVector(v,i);
      encontrado := true;
    end;
    i := i + 1;
  end;

  if (encontrado) then writeln('Alumno eliminado correctamente.')
  else writeln('Alumno no encontrado.');
end;

procedure escribirArreglo(v : arregloAlumnos);
var i : integer;
begin
  for i := 1 to v.dimL do writeln(i,'. ', v.v[i]);
end;

var alumno : nombre; v : arregloAlumnos;
begin
  v.dimL := 0;
  writeln('diml: ', v.dimL);
  write('Ingrese un nombre: '); readln(alumno);
  while ((alumno <> 'ZZZ') and (v.dimL <= 500)) do begin
    cargarAlumno(v, alumno);
    write('Ingrese un nombre: '); readln(alumno);
  end;
  escribirArreglo(v);
  writeln;
  eliminarAlumno(v);
  escribirArreglo(v);
end.
