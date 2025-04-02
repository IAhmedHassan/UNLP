// See https://aka.ms/new-console-template for more information
// Console.WriteLine("Hello, World!");

// double d = 15.1;
// float f = 21.2f;


// double r1 = 17 / 3;
// double r2 = 17 / 3.0;

// Console.WriteLine(r1);
// Console.WriteLine(r2);


// /*
// string nombre = (Console.ReadLine());
// if (true) {
// Console.WriteLine("Hola " + nombre + "!");
// }

// Console.WriteLine(nombre == "Pelo" ? "ke ase wachin" : "Un placer."); 
// */
// Console.WriteLine("escribi un numero pue");
// int num = 0;
// int n = int.Parse(Console.WriteLine());
// for (int i = 1; i <= n ; i++) {
//     num += i;
// }
// Console.WriteLine(num);

Console.WriteLine("Ingrese dos palabras separadas por un espacio:");
string st = Console.ReadLine().Trim();

// Verifica que haya sólo un espacio entre las dos palabras.
while (st.Count(c => c == ' ') != 1) {
    Console.WriteLine("Ingrese dos palabras separadas por un espacio:");
    st = Console.ReadLine().Trim();
}

// Recorre las dos palabras buscando el falso.
int i = 0;
bool simetricas = true;
while (st[i] != ' ') {
    if (st[i] != st[st.Length-(++i)]) {
        simetricas = false;
        break;
    }
}
Console.WriteLine(simetricas);
