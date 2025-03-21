program 2;

type
  tfecha : record
    dia : integer;
    mes : integer;
    año : integer;
  end;

  venta = record
    cod : integer;
    fecha : tfecha;
    cantidad: integer;
  end;


  arbol = ^nodo;

  nodo = record
    dato: venta;
    HI : arbol;
    HD : arbol;
  end;

var a : arbol;
begin

end;
