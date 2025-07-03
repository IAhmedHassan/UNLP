program ej3;
type
    VALOR_ALTO = 'ZZZ';

    provincia = record
        nombre : string[50];
        cantEncuestados : integer;
        cantPersonasAlfabetizadas : integer;
    end;

    infoDetalle = record
        provincia : string[50];
        codLoc : integer;
        cantEncuestados : integer;
        cantAlfabetizados : integer;
    end;

    maestro = file of provincia;
    detalle = file of infoDetalle;

procedure leer(var arch : detalle; var d : infoDetalle);
begin
    if not EOF(arch) then
        read(arch, d);
    else d.provincia := VALOR_ALTO;
end;

procedure leerM(var arch : maestro; var m : provincia);
begin
    if not EOF(arch) then
        read(arch, m);
    else m.nombre := VALOR_ALTO;
end;

procedure minimo(var d1, d2 : detalle; var regd1, regd2, min : infoDetalle);
begin
    if (regd1.provincia < regd2.provincia) 
        then begin
            min := regd1;
            leer(d1, regd1);
        end;
        else begin
            min := regd2;
            leer(d2, regd2);
        end;
end;

procedure escribirMaestro(var m : maestro; regm : provincia);
begin
    seek(m, filePos(m) -1);
    write(m, regm);
end;

procedure actualizarMaestro(var m : maestro; var d1, d2 : detalle);
var regm : provincia; regd1, regd2, min : infoDetalle; 
    provActual : string[50]; encuestados : integer; alfabetizados :integer;

begin
    reset(m); reset(d1); reset(d2);
    leer(d1, regd1);
    leer(d2, regd2);
    leerM(m, regm);
    minimo(d1,d2, regd1, regd2, min);
    while(min.provincia <> VALOR_ALTO) do begin
        provActual := min.provincia;
        encuestados := 0; alfabetizados := 0;
        while (min.provincia = provActual) do begin
            encuestados := encuestados + min.cantEncuestados;
            alfabetizados := alfabetizados + min.cantAlfabetizados;
            minimo(d1, d2, regd1, regd2, min);
        end;

        while (regm.nombre <> provActual) do leerM(m, regm);

        regm.cantEncuestados := regm.cantEncuestados + encuestados;
        regm.cantAlfabetizados := regm.cantAlfabetizados + alfabetizados;
        escribirMaestro(m, regm);
    end;
    close(d1); close(d2); close(m);
end;


var m : maestro; d1, d2 : detalle; 
    regM : provincia;
    regD1, regD2 : detalle;

begin
    assign(m, 'maestro.dat');
    assign(d1, 'detalle1.dat');
    assign(d2, 'detalle2.dat');
    actualizarMaestro(m, d1, d2);
end.
