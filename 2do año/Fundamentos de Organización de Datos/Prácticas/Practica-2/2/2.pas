program ej2;
const VALOR_ALTO = 9999;

type
    producto = record
        cod : integer;
        nombre : string[20];
        precio : real;
        stockActual: integer;
        stockMinimo: integer;
    end;

    venta = record
        cod : integer;
        cantidadUV : integer;
    end;

    productos = file of producto;
    ventas = file of venta;

procedure menu();
begin
    writeln('1.');
    writeln('2.');
    writeln('0.');
end;

procedure leerD(var arch : ventas; var v : venta);
begin
    if not EOF(arch)
        then read(arch,v)
        else v.cod := VALOR_ALTO;
end;

procedure actualizarMaestro(var m : productos ; var d : ventas);
var p : producto; v, act : venta; totalProd : integer;
begin
    reset(m); reset(d);
    leerD(d,v);
    while (v.cod <> VALOR_ALTO) do begin
        act := v;
        totalProd := 0;
        while (v.cod = act.cod) do begin
            totalProd := totalProd + v.cantidadUV;
            leerD(d,v);
        end;
        act.cantidadUV := totalProd;
        
        { procedure escribirMaestro(m, p) ahre }
        read(m,p);
        while (p.cod <> act.cod) do read(m,p);
        p.stockActual := p.stockActual - act.cantidadUV;
        seek(m, FilePos(m) - 1);
        write(m,p);
        { ahrend; }
    
    end;
    close(m); close(d);
end;

procedure listarStockMinimo(var m : productos);
var t : Text; p : producto;
begin
    reset(m);
    assign(t, 'StockMinimo.txt');
    rewrite(t);
    while not EOF(m) do begin
        read(m,p);
        if (p.stockActual <= p.stockMinimo) then writeln(t, p.cod, ' | ', p.nombre, ': $', p.precio, ' | ', p.stockActual);
    end;
end;


var mae : productos; det : ventas; opcion : integer;
begin
    assign(mae, 'Productos.dat');
    assign(det, 'Detalles.dat');
    repeat
        menu();
        write('Elige una opción: '); readln(opcion);
        case opcion of
            1: actualizarMaestro(mae,det);
            2: listarStockMinimo(mae);
            0: writeln('Saliendo');
            else writeln('flashaste metele otro o rajá');
        end;
    until (opcion = 0);
end.