{
Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).
}

program ej3;
type

  pelicula = record
    cod: integer;
    genero: integer;
    puntaje: real;
  end;

  lista = ^nodo;
  
  nodo = record
    dato : pelicula;
    sig : lista;
  end;

  vectorGenero = array [1..8] of pelicula;

procedure insertarAtras(var L, ult : lista; nuevo: pelicula);
var aux : lista;
begin
  new(aux); aux^.dato := nuevo; aux^.sig := nil;
  if L = nil then begin
    L:= aux;
    ult := L;
  end
  else begin
    ult^.sig := aux;
    ult := ult^.sig;
  end;    
end;

procedure cargarLista(var L : lista);
var nuevo : pelicula; ult : lista;
begin
  writeln('--- INGRESO DE PELICULAS ---');
  writeln('a continuación, cargá la lista de pelis disponibles. ');
  writeln;
  write('Ingrese Código de película: '); readln(nuevo.cod);
  while (nuevo.cod <> -1) do begin
    write('Ingrese el género (del 1 al 8): '); readln(nuevo.genero);
    write('Ingrese su puntuación promedio: '); readln(nuevo.puntaje);
    writeln;
    insertarAtras(L, ult, nuevo);
    write('Ingrese Código de película: '); readln(nuevo.cod);
  end;
  writeln('--- FIN INGRESO ---');
end;

procedure recorrerLista(L : lista);
var i : integer;
begin
  i := 1;
  while L <> nil do begin
    writeln(i, '.');
    writeln('Código de pelicula: ' ,L^.dato.cod);
    writeln('Género: ' , L^.dato.genero);
    writeln('Puntaje: ' , L^.dato.puntaje:0:2);
    writeln;
    i := i + 1;
    L := L^.sig;
  end;
end;

procedure buscarMejordelGenero(L : lista; i : integer;var aux : pelicula);
var mejor : lista; maxpunt: real;
begin
  maxpunt := 0;
  while L <> nil do begin
    if ((L^.dato.genero = i) AND (L^.dato.puntaje > maxpunt)) then begin
      mejor := L;
      maxpunt := L^.dato.puntaje;
    end;
    L := L^.sig;
  end;
  aux := mejor^.dato;
end;

procedure mejorPuntajePorGenero(L : lista;var v : vectorGenero);
var i : integer; aux : pelicula;
begin
  for i := 1 to 8 do begin
    buscarMejordelGenero(L,i,aux);
    v[i] := aux;
    writeln('Mejor pelicula del género ', i,': ', aux.cod);
  end;
end;


var L : lista; v : vectorGenero; 

begin
  writeln('TUDUM!');
  writeln('Bienvenido a Netflix!');
  writeln;
  cargarLista(L);
  recorrerLista(L);
  mejorPuntajePorGenero(L, v);
end.
