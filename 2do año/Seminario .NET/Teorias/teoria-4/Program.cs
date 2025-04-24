// See https://aka.ms/new-console-template for more information
using toria_4;

Auto a = new Auto("Citröen", 2013);
Console.WriteLine(a.ObtenerDescripcion());

Auto b = new Auto("Fiat", 2006);
Console.WriteLine(b.ObtenerDescripcion());

a = new Auto();
Console.WriteLine(a.ObtenerDescripcion());

a = new Auto("Renault");
Console.WriteLine(a.ObtenerDescripcion());

