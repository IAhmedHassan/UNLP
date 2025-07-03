namespace Teoria_8;
class Auxiliar
{
       public void Procesar()
   {
      List<int> lista = [11, 5, 90];
      var lista1 =  Seleccionar(lista,SumaUno);
      Imprimir(lista1);
      var lista2 =  Seleccionar(lista,SumaDos);
      Imprimir(lista2);
   }
    int SumaUno(int n) => n + 1;
    int SumaDos(int n) => n + 2;

      List<int> Seleccionar(List<int> lista, FuncionEntera f)
   {
       var result = new List<int>();
       foreach (int valor in lista)
       {
           result.Add(f(valor));
       }
       return result;
   }
   void Imprimir(List<int> lista)
   {
       foreach (int i in lista)
       {
           Console.Write(i + " ");
       }
       Console.WriteLine();
   }
}