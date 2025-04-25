using practica_4;

Console.SetIn(new StreamReader("personas.txt"));
Persona? LeerPersona() {

    Console.WriteLine("Ingrese nombre, dni y edad separado por comas (ENTER para salir):");
    string[] input = Console.ReadLine().Split(",");
    if (input[0] != "") {
        Persona per = new Persona(input[0], int.Parse(input[1]), int.Parse(input[2]));
        return per;
    }
    return null; 
}

Persona? p;
LinkedList<Persona> personas = new LinkedList<Persona> {};
p = LeerPersona();
while (p != null) {
    personas.AddLast(p);
    p = LeerPersona();
}

int i = 1;
Persona min = new Persona("",0,999);
foreach (Persona per in personas) {
    Console.Write($"{i}) ");
    per.Imprimir();
    if (per.Edad < min.Edad) min = per;
    i++;
}
Console.Write($"Persona con edad minima:");
min.Imprimir();
