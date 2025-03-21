program empresa;
type
  MetododePago: 1..2;
  venta = record
    cod : integer;
    cantProds : integer;
    Pago : MetododePago;
  end;

  lista = ^nodo;

  nodo = record
    dato : venta;
    sig : lista;
  end;

procedure generarListaPares(LOr: lista, var L : lista);

  function tieneMasPares(n : integer);
  var pares : integer = 0; impares : integer = 0; resto : integer;
  begin
    while (n > 0) do begin
      resto := n mod 10;
      if ((resto mod 2) = 0) then 
        pares := pares + 1 
      else impares := impares + 1;
      n := n div 10;
    end;
    tieneMasPares := pares > impares;
  end;

  procedure concatenarListas(L1, L2 : lista);
  begin
    while (L1^.sig <> nil) do L1 := L1^.sig;
    L1^.sig := L2;
  end

var LT : lista = nil;
begin
  while (LOr <> nil) do begin
    if (tieneMasPares(L^.dato.cantProds)) then begin
      if (L^.dato.Pago = 1) then cargarLista(L) else cargarLista(LT);
    end;
    LOr := LOr^.sig;
  end;
  concatenarListas(L, LT);
end;

var LOr : lista = nil; L : lista = nil;
begin
  generarLista(LOr); {se dispone}
  generarListaPares(LOr, L);
end.
