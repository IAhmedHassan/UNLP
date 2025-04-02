// See https://aka.ms/new-console-template for more information

void RunAll()
{
    RunBlock1();
    RunBlock2();
    RunBlock3();
    RunBlock4();
    RunBlock5();
    RunBlock6();
    RunBlock7();
    RunBlock8();
    RunBlock9();
    RunBlock10();
    RunBlock12();
}

void RunBlock1()
{
    Console.WriteLine("1. Hola Mundo!");
    Console.WriteLine("WriteLine escribe una línea y luego salta a la siguiente");
    Console.Write("Write escribe una línea y se queda en la misma línea");
    Console.WriteLine();
    Console.Write("Hola ");
    Console.ReadKey();
    Console.WriteLine("Mundo!");
}

void RunBlock2()
{
    Console.WriteLine("2. Uso de caracteres de escape");
    Console.WriteLine("uso slash n \n para saltar de línea");
    Console.WriteLine("uso slash t \t para tabular");
    Console.WriteLine("uso slash " + "\"" + " para escribir comillas");
    Console.WriteLine("uso slash \\ para escribir una barra invertida");
}

void RunBlock3()
{
    Console.WriteLine("3. Uso de @");
    Console.WriteLine(@"uso @ para escribir una cadena literal
    sin necesidad de usar caracteres de escape
    como \n, \t, \"", \\");
    string st = "C:\\Users\\Usuario\\Documents";
    string stWithAt = @"C:\Users\Usuario\Documents";
    Console.WriteLine(st);
    Console.WriteLine(stWithAt);   // Ambos muestran lo mismo
}

void RunBlock4()
{
    Console.Write("4. Ingrese su nombre: ");
    string nombre = Console.ReadLine();
    if (nombre != "") {
        Console.WriteLine("Hola " + nombre + ", cómo estás?");
    } else {
        Console.WriteLine("Hola Mundo!");
    }
    Console.WriteLine(nombre != "" ? "Hola " + nombre + ", cómo estás?" : "Hola Mundo!");   
}

void RunBlock5()
{
    string nombre = "";
    while (nombre != "0") {
        Console.Write("5. Ingrese su nombre: ");
        nombre = Console.ReadLine();
        // //a. usando if ... else if
        // if (nombre == "Juan") {Console.WriteLine("Hola amigo!");} else 
        // if (nombre == "María") {Console.WriteLine("Buen día señora!");} else
        // if (nombre == "Alberto") {Console.WriteLine("Hola Alberto");} else
        // if (nombre == "0") {Console.WriteLine("Buen día Crocodile, pase");} else
        // if (nombre != "") {Console.WriteLine("Buen día " + nombre);}
        // else {Console.WriteLine("Buen día mundo!");};
        //b. usando switch
        switch(nombre) {
            case "Juan": Console.WriteLine("Hola amigo!"); break;
            case "Alberto":Console.WriteLine("Hola Alberto"); break;
            case "María":Console.WriteLine("Buen día señora!"); break;
            case "":Console.WriteLine("Buen dia Mundo!"); break;
            case "0": Console.WriteLine("Buen día Crocodile, pase"); break;
            default: Console.WriteLine("Buen dia " + nombre); break;
        }
    }
}

void RunBlock6()
{
    Console.WriteLine("6. cantidad de caracteres en un string");
    string cadena = "";
    while (cadena != "0") {
        Console.Write("Escriba una cadena: ");
        cadena = Console.ReadLine();
        Console.WriteLine("Cantidad de caracteres: " + cadena.Length);
    }
}

void RunBlock7()
{
    Console.WriteLine("7. Qué hace la función 'Console.WriteLine(\"100\".Length);' ?");
    Console.WriteLine("Devuelve la cantidad de caracteres en dicho string: " + "100".Length);
}

void RunBlock8()
{
    Console.WriteLine("8. si st es un string bien declarado, es válido hacer 'Console.WriteLine(st = Console.ReadLine());' ?"); 
    string st;
    Console.WriteLine(st = Console.ReadLine()); // es válido            
}

void RunBlock9()
{
    Console.WriteLine("9. Palabras simétricas");
    string st = "";
    while (st != "0") {
        bool simetrico = true;
        Console.Write("Ingrese 2 palabras: "); 
        st = Console.ReadLine();
        for (int i = 0; i <= st.Length/2; i++) {
            if (st[i] != st[st.Length - (i + 1)]) {
                simetrico = false;
                break;
            }
        }
        Console.WriteLine(simetrico ? "Es simétrico." : "No es simétrico.");
    }
}

void RunBlock10()
{
    Console.WriteLine("10.Escribir un programa que imprima en la consola todos los múltiplos de 17 o de 29 comprendidos entre 1 y 1000.");
    bool calc17 = true, calc29 = true; int n, i = 1;
    while (calc17 || calc29) { 
        if (calc17) Console.Write((n = 17 * i) < 1000 ? n + " " : calc17 = false );
        if (calc29) Console.Write((n = 29 * i) < 1000 ? n + " " : calc29 = false );
        i++;
    }
    Console.WriteLine(".");
}

void RunBlock12()
{
    Console.WriteLine("12.Escribir un programa que imprima todos los divisores de un número entero ingresado desde la consola. Para obtener el entero desde un string st utilizar int.Parse(st).");
    int n;
    do {
        Console.Write("ingrese un número (-1 pa salir): ");
        n = int.Parse(Console.ReadLine());
        if (n != -1) {
            for (int i = 1 ; i < n ; i++) {
                Console.Write((n % i == 0) ? i + " " : ""); 
            }
        }
        Console.WriteLine();
    } while (n != -1);
}

void ShowMenu()
{
    Console.WriteLine("1. Hola Mundo!");
    Console.WriteLine("2. Uso de caracteres de escape");
    Console.WriteLine("3. Uso de @");
    Console.WriteLine("4. Ingrese su nombre");
    Console.WriteLine("5. Ingrese su nombre con switch");
    Console.WriteLine("6. Cantidad de caracteres en un string");
    Console.WriteLine("7. Qué hace la función 'Console.WriteLine(\"100\".Length);' ?");
    Console.WriteLine("8. Validar 'Console.WriteLine(st = Console.ReadLine());'");
    Console.WriteLine("9. Palabras simétricas");
    Console.WriteLine("10. Múltiplos de 17 o 29 entre 1 y 1000");
    Console.WriteLine("12. Divisores de un número entero");
    Console.WriteLine("A. Ejecutar todos los bloques");
    Console.WriteLine("0. Salir");
    Console.Write("\nSeleccione una opción:");
}

void Main()
{
    string? option = null;
    do
    {
        if (option != null) {Console.WriteLine("\n\nPresione una tecla para continuar...");Console.ReadKey();}
        Console.Clear();
        ShowMenu();
        option = Console.ReadLine();
        switch (option)
        {
            case "1": Console.Clear(); RunBlock1(); break;
            case "2": Console.Clear(); RunBlock2(); break;
            case "3": Console.Clear(); RunBlock3(); break;
            case "4": Console.Clear(); RunBlock4(); break;
            case "5": Console.Clear(); RunBlock5(); break;
            case "6": Console.Clear(); RunBlock6(); break;
            case "7": Console.Clear(); RunBlock7(); break;
            case "8": Console.Clear(); RunBlock8(); break;
            case "9": Console.Clear(); RunBlock9(); break;
            case "10":Console.Clear(); RunBlock10(); break;
            case "12":Console.Clear(); RunBlock12(); break;
            case "A": RunAll(); break;
            case "0": Console.WriteLine("\n\nSaliendo..."); break;
            default: Console.WriteLine("Opción no válida"); break;
        }
    } while (option != "0");
}

Main();