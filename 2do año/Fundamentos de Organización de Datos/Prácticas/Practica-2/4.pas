program ejercicio4;

const VALOR_ALTO = 'ZZZ';

type
    provincia = record
        nombre : string;
        cantA : integer;
        totalE : integer;
    end;

    det = record
        nombre : string;
        codL : integer;
        cantA : integer;
        cantE : integer;
    end;

    maestro = file of provincia;
    detalle = file of det;

    procedure leerD (var arch : detalle ; var d : det);
    begin
        if not EOF(arch) 
            then read(arch,d)
            else p.nombre := VALOR_ALTO;
    end;

    procedure leerM (var arch : maestro ; var p : provincia);
    begin
        if not EOF(arch)
            then read(arch,p);
            else p.nombre := VALOR_ALTO;
    end;

    procedure minimo(var r1, r2, min: det ;
                     var a1, a2, : detalle);
    begin
        if(r1.nombre < r2.nombre) 
            then begin
                min := r1;
                leerD(a1);
            end;
            else begin
                min := r2;
                leerD(a2);
            end;
    end;

    procedure actualizar(var mae : maestro ; var d: detalle ; var d1 : detalle);
    var regm : provincia ; regd, regd1, min : det;
        act : String; totalA, totalE : integer;
    begin
        reset(mae); reset(d); reset(d1);
        leerD(d, regd); leerD(d1, regd1);
        leerM(mae, regm);
        minimo(d,d1,regd, regd1, min);
        while (min.nombre <> VALOR_ALTO) do begin
            act := min.nombre;
            totalA := 0;
            totalE := 0;
            while(act = min.nombre) do begin
                totalA := totalA + min.cantA;
                totalE := totalE + min.cantE;
                minimo(d, d1, regd, regd1, min)
            end;
            while (act <> regm.nombre) do leerM(mae, regm);

            regM.cantA := regm.cantA + totalA;
            regM.totalE := regm.totalE + totalE;
            seek(m, filePos(mae) - 1);
            write(mae, regm);
            if not EOF(mae) then leerM(mae, regm);
        end;

        close(mae);close(d);close(d1);
    end;

var mae : maestro; d,d1 : detalle;
begin
{assigns y actualizar}
    

