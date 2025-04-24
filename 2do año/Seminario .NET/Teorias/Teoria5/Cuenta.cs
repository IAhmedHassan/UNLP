namespace Teoria5;

    public class Cuenta{
        public int _monto; // _variable para variables de instancia
        public static int s_total; // s_variable para variables estáticas (globales, no pueden accederse desde instancias)
        public static void ImprimirResumen() => Console.WriteLine($"Total: {s_total}"); 
        public /* static */ void Imprimir() => Console.WriteLine($"Monto: {_monto}");
        public void Depositar(int monto) {
            _monto += monto;
            Cuenta.s_total += monto;
        } 

    }