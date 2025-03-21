procedure ejA (v: vEnteros; dimL: integer);
var i: integer;

begin
  for i:= 1 to dimL do begin
    writeln(v[i]);
  end;
end;

{--------------------------------------------------------}

procedure ejB (v: vEnteros; dimL: integer);
var i: integer;
begin
  for i:= dimL downto 1 do begin
    writeln(v[i]);
  end;
end;

{--------------------------------------------------------}

procedure ejC (v: vEnteros; dimL: integer);
var i, mid: integer;
begin
  mid:= dimL DIV 2;
  for i:= mid downto 1 do begin
    writeln(v[i]);
  end;
  
  for i:= (mid + 1) to dimL do begin
    writeln(v[i]);
  end;
end;

{---------------------------------------------------------}
{1,2,3,4,5}
procedure ejD (v: vEnteros; x, y: integer);
var i:= integer;
begin
  if x <= y then begin
    for i:=x to y do writeln(v[i]);

  else begin
    for i:= x downto y do writeln(v[i]);

  end;
end;