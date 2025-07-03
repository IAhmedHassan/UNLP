program nombrePrograma;

uses SysUtils, crt;

type
  celular = record
    cod : integer;
    nom : string[30];
    descripcion : string;
    marca : string[15];
    precio : real;
    stockMin : integer;
    stock : integer;
  end;

  celus = file of celular;

{------------------------------------------------------------------------}

procedure titulo(nombre: string);
begin
  writeln('===============================');
  writeln('         ', UpperCase(nombre));
  writeln('===============================');
end;

{------------------------------------------------------------------------}

procedure esperar();
begin
  writeln;
  writeln;
  write('Presione una tecla para continuar...');
  ReadKey;

end;

{------------------------------------------------------------------------}

procedure menu(var fcel : celus);

  procedure chequearArchivo(var fcel : celus);
  begin
    reset(fcel);
    if (filesize(fcel) = 0) 
      then writeln('Archivo vacío. Créelo antes de iniciar.')
      else writeln(filesize(fcel), ' elementos cargados.');
    close(fcel);
  end;

begin
  titulo('Menú Principal');
  chequearArchivo(fcel);
  writeln;
  writeln('1. Actualizar archivo');
  writeln('2. Listar celulares con stock menor al mínimo');
  writeln('3. Buscar celular por descripción');
  writeln('4. Exportar listado a archivo de texto');
  writeln('5. Listar Elementos');
  writeln('6. Agregar Elementos');
  writeln('7. Modificar Stock');
  writeln('8. Exportar lista sin stock');
  writeln('0. Salir');
  writeln('===============================');
end;

{------------------------------------------------------------------------}

procedure imprimirCelular(c : celular);
begin
  writeln(c.cod,'. ',c.marca, ' ', c.nom, ' | $', c.precio:0:2);
  writeln(c.descripcion);
  writeln('STOCK: ', c.stock);
  writeln;
end;

{------------------------------------------------------------------------}
  
procedure crearArchivo(var fcel : celus);
var tf : Text; c : celular; buff : string[1]; { ACA GABI }
begin
  assign(tf, 'celulares.txt');
  reset(tf);
  rewrite(fcel);
  while not EOF(tf) do begin
    readln(tf,c.cod,c.precio,buff,c.marca);
    readln(tf,c.stock,c.stockMin,buff,c.descripcion);
    readln(tf,c.nom);
    write(fcel,c);
  end;
  writeln('Archivo actualizado correctamente.');
  close(tf); close(fcel);
end;

{------------------------------------------------------------------------}

procedure listarElementos(var fcel : celus);
var c : celular;
begin
  titulo('Listado de Elementos');
  reset(fcel);
  while not EOF(fcel) do begin
    read(fcel, c);
    imprimirCelular(c);
  end;
end;

{------------------------------------------------------------------------}

procedure listarStockMinimo(var fcel : celus);
var c : celular;
begin
  titulo('Listar Stock Mínimo');
  reset(fcel);
  while not EOF(fcel) do begin
    read(fcel,c);
    if (c.stock < c.stockMin) then imprimirCelular(c);
  end;
  close(fcel);
end;

{------------------------------------------------------------------------}

procedure buscarPorDescripcion(var fcel : celus);
var st : string; c : celular;
begin
  titulo('Buscar Por Descripción');
  write('Texto a buscar: '); readln(st);
  reset(fcel);
  while not EOF(fcel) do begin
    read(fcel, c);
    if (c.descripcion = st) then imprimirCelular(c);
  end;
  close(fcel);
end;

{------------------------------------------------------------------------}

procedure escribirCelu(var tf: Text; c : celular);
begin
  writeln(tf,c.cod,' ',c.precio,' ',c.marca);
  writeln(tf,c.stock,' ',c.stockMin,' ',c.descripcion);
  writeln(tf,c.nom);
end;

{------------------------------------------------------------------------}

procedure exportarListado(var fcel : celus);
var tf : Text; c : celular;

begin
  assign(tf,'celulares.txt');
  reset(fcel); rewrite(tf);
  while not EOF(fcel) do begin
    read(fcel, c);
    escribirCelu(tf,c);
  end;
  close(fcel); close(tf);
end;

{------------------------------------------------------------------------}

procedure agregarElementos(var fcel : celus);
{ LEER, CHEQUEAR UNICIDAD Y DESPUES ABRIR ARCHIVO Y AGREGAR}

  procedure leerCelular(var c : celular; var fcel : celus);
  
    function esUnico(cod : integer; var fcel : celus): boolean; {PUEDE RETORNAR POSICION PA SER MAS REUTILIZABLE}
    var c : celular; encontrado : boolean = false;
    begin
      reset(fcel);
      while (not encontrado and not EOF(fcel)) do begin
        read(fcel, c);
        if (c.cod = cod) then encontrado := true;
      end;
      close(fcel);
      esUnico := encontrado;
    end;

  begin
    
    write('Código(-1 para salir): '); readln(c.cod);
    if (c.cod <> -1) then begin
      if esUnico(c.cod, fcel) then begin
        write('Marca: '); readln(c.marca);
        write('Modelo: '); readln(c.nom);
        write('Precio: $'); readln(c.precio);
        write('Stock: '); readln(c.stock);
        write('Stock Mínimo: '); readln(c.stockMin);
        write('Descripción: '); readln(c.descripcion);
      end
      else begin
        writeln('Ese código ya existe, intente nuevamente.'); end;
    end;
  end;

var c : celular;

begin
  titulo('Agregar elementos');
  reset(fcel);
  seek(fcel,filesize(fcel));
  leerCelular(c, fcel);
  while (c.cod <> -1) do begin
    write(fcel, c);
    leerCelular(c, fcel);
  end; 
  close(fcel);

end;

{------------------------------------------------------------------------}

procedure modificarStock(var fcel : celus);
var codigo : integer; encontrado : boolean = false; c : celular;

  procedure actualizarStock(var fcel : celus; pos : integer; c : celular);
  begin
    seek(fcel, pos - 1);
    write(fcel, c);
  end;

begin
  titulo('Modificar Stock');
  reset(fcel);
  write('Código del producto a modificar: '); readln(codigo);
  while (not EOF(fcel) and not encontrado) do begin
    read(fcel, c);
    if (c.cod = codigo)
      then begin
        imprimirCelular(c);
        write('Stock actualizado: '); readln(c.stock);
        actualizarStock(fcel, filePos(fcel), c);
        writeln;
        writeln('Producto actualizado.');
        encontrado := true;
      end;
  end;
  if not encontrado then writeln('No existe un producto con ese código. Intente nuevamente.');
  close(fcel);
end;


{------------------------------------------------------------------------}

procedure exportarListaSinStock(var fcel : celus);
var c : celular; tf : Text;
begin
  assign(tf, 'SinStock.txt');
  reset(fcel); rewrite(tf);
  while not EOF(fcel) do begin
    read(fcel, c);
    if c.stock = 0 then escribirCelu(tf, c); 
  end;
  writeln('Archivo exportado correctamente.');
  close(fcel); close(tf);
end;

{------------------------------------------------------------------------}
{------------------------------------------------------------------------}
{------------------------------------------------------------------------}

var
  fcel : celus;
  opcion : integer;
  nom : string;

begin
  write('Archivo: '); readln(nom);
  assign(fcel, nom);
  writeln('Abriendo menú.');
  repeat
    esperar();
    clrscr;
    menu(fcel);
    write('Ingrese una opción: '); readln(opcion);
    clrscr;
    case opcion of
      1: crearArchivo(fcel);
      2: listarStockMinimo(fcel);
      3: buscarPorDescripcion(fcel);
      4: exportarListado(fcel);
      5: listarElementos(fcel);
      6: agregarElementos(fcel);
      7: modificarStock(fcel);
      8: exportarListaSinStock(fcel);
      0: writeln('Saliendo.');
      else writeln('No es una opción válida.');

    end;
  until(opcion = 0);
end.
