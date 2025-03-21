program valorAbsoluto;
var num: real;
begin
  write('ingrese un numero: '); read(num);
  if (num < 0) then writeln('|',num,'| = ', -num)
  else writeln('|',num,'| = ', num);
end.