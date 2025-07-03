
namespace Teoria_7;

class Automotor : IImprimible
{
   protected string Marca = "";
   public void Imprimir() => Console.WriteLine($"Marca: {Marca}");
}