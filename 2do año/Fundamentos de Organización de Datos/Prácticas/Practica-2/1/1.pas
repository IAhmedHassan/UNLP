 program ej1;
const VALOR_ALTO = 9999;
type
    comision = record;
        codEmp : integer;
        nombre : string;
        monto : real;
    end;


    comisiones = file of comision;

procedure leer(var arch : comisiones, var c : comision);
begin
    if not EOF(arch) 
        then read(arch, c);
        else c.cod := VALOR_ALTO;
end;

procedure imprimirArchivo(var arch);
var c : comision;
begin
    read(arch,c);
end;

procedure compactar(var o, n: comisiones );
var c, act: comision; totalEmp : integer;
begin
    while (c.cod <> VALOR_ALTO) do begin
        act := c;
        totalEmp := 0
        while (c.cod = act.cod) do begin
            totalEmp := totalEmp + c.monto;
            leer(c,o);
        end;
        act.monto := totalEmp;
        write(act,n);
    end;
    close(o);
    close(n);
end;


var 
    orig, nuevo: comisiones;
begin
    assign(orig, 'comisiones.dat');
    assign(nuevo, 'pagoEmpleados.dat');
    
    reset(orig);
    rewrite(nuevo);
    compactar(orig,nuevo);
    close(orig);
    close(nuevo);

    reset(nuevo);
    ImprimirArchivo(n);
    close(nuevo);
end.