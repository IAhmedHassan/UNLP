namespace practica_4;
class Persona {
        string Nombre {get;}
        int DNI {get;}
        public int Edad {get;}

        public Persona(string nombre, int dni, int edad) {
            Nombre = nombre;
            DNI = dni;
            Edad = edad;
        }

        public void Imprimir() {
            Console.WriteLine($"{Nombre,-10} {DNI,-10} {Edad}");
        }

        public bool EsMayorQue(Persona p) {
            return this.Edad > p.Edad;
        }
}