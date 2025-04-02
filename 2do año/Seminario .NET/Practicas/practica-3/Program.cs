Main();

void Main() {

    string? op = null;
    do {
        if (op == null) Console.Clear();
        Menu(); 
        op = Console.ReadLine();
        switch (op) {
            case "1" : ej1(); break;
            case "2" : ej2(); break;
            case "3" : ej3(); break;
            case "0" : break;
            default: Console.WriteLine("Opción inválida."); break; 
        }    
    } while (op != "0");
}

void ej1() {

    Console.CursorVisible = false;
    ConsoleKeyInfo k = Console.ReadKey(true);
    while (k.Key != ConsoleKey.End) {
        Console.Clear();
        Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
        k = Console.ReadKey(true);
    }
    return;
}

void ej2() {
    double[,] m = initMatrix();
    Console.WriteLine("Imprimiendo:");
    ImprimirMatriz(m);
    
}

void ej3() {
    double[,] m = initMatrix();
    ImprimirMatriz(m);
    try {
        double[] diagP = GetDiagonalPrincipal(m);
        double[] diagS = GetDiagonalSecundaria(m);
        // double[,] diagonales = new double[,] {{diagP},{diagS}};
        Console.WriteLine("Diagonal Principal: "); ImprimirArreglo(diagP);
        Console.WriteLine("Diagonal Secundaria: "); ImprimirArreglo(diagS);

    } catch (ArgumentException) {
        Console.WriteLine("La matriz no es cuadrada.");
    }
}

void Menu() {
    Console.WriteLine("1. Ej1");
    Console.WriteLine("2. Ej2");
    Console.WriteLine("3. Ej3");
    Console.WriteLine("0. Salir");
    Console.Write("Ingrese una opción: ");
}

double[,] initMatrix() {
    Console.WriteLine("Dimensiones:");
    Console.Write("Filas: ");  
    string? st = Console.ReadLine();
    int f = int.Parse(st);
    Console.Write("Columnas: ");  
    st = Console.ReadLine();
    int c = int.Parse(st);
    double[,] arr = new double[f,c];
    int num = 1;
    for (int i = 0; i < f; i++) {
        for (int j = 0 ; j < c ; j++ ) {
            arr[i,j] = num; num++;
        }
    }
    return arr;
}

double[] GetDiagonalPrincipal(double[,] matriz) {
    if (matriz.GetLength(0) == matriz.GetLength(1)) {

        double[] arr = new double[matriz.GetLength(0)];
        for(int i = 0 ; i < matriz.GetLength(0); i++) arr[i] = matriz[i,i];
        return arr;

    } else throw new ArgumentException("La matriz no es cuadrada");
}

double[] GetDiagonalSecundaria(double[,] matriz) {
    if (matriz.GetLength(0) == matriz.GetLength(1)) {

        double[] arr = new double[matriz.GetLength(0)];
        for(int i = matriz.GetLength(0) - 1  ; i >= 0 ; i--) arr[i] = matriz[i,i];
        return arr;

    } else throw new ArgumentException("La matriz no es cuadrada");
}

void ImprimirMatriz(double[,] m) {
    for (int i = 0 ; i < m.GetLength(0) ; i++) {
        for (int j = 0 ; j < m.GetLength(1) ; j++) {
            Console.Write($"{m[i,j],3} | ");
        }
        Console.WriteLine();
    }
}

void ImprimirArreglo(double[] m) {
    for (int i = 0; i < m.GetLength(0); i++) Console.Write($"{m[i],3} | ");
    Console.WriteLine();
}
