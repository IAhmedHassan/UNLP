program CargarLista;
type
        lista : ^nodo;
        nodo = record
                dato : integer;
                sig : lista;
        end;

procedure InsertarNodo(var L, ult, aux : lista);
begin
        if L.sig = nil then begin
                L := aux;
                ult := L;
        end
        else begin
                ult
        end;
end;

procedure CargarLista(var L : lista);
var aux, ult : lista; rand : integer;
        
        randomize;
        rand := random(150 - 100) +100;
        while rand <> 120 do begin
                new(aux);
                aux.dato := rand;
                aux.sig := nil;
                InsertarNodo(L,ult,aux);
        end;

end;


var L : lista;

begin
        L.sig := nil;
        CargarLista(L);
end.
