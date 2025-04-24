class Persona {
    public string Nombre {get;}
    public int Edad {get;}

    public Persona(string nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }
    public void Imprimir() => Console.WriteLine($"{Nombre} {Edad}");
}