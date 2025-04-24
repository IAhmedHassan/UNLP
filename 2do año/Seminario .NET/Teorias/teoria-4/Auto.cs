using System;

namespace toria_4;

public class Auto //Pueden declararse campos de instancia aqui mismo entre paréntesis -> (string marca, in modelo)
{
    string _marca;
    int _modelo;
    public Auto(string marca, int modelo) {
        _marca = marca;
        _modelo = modelo;
    }
    public Auto() {
        _marca = "Nissan";
        _modelo = DateTime.Now.Year;
    }
    public Auto(string marca) : this() { // : this() invoca al constructor sin parámetros antes de ejecutar lo que contiene este constr
        _marca = marca; 
    }
    /*
    También puede implementarse como:

        public Auto(string marca) : this(marca, DateTime.Now.Year) {}d

    */

    public string ObtenerDescripcion() => $"Auto {_marca} {_modelo}";


}
