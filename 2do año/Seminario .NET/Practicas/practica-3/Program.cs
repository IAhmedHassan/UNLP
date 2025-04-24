using System.Text;

Main();

void Main()
{

    string? op = null;
    do
    {
        if (op == null) Console.Clear();
        Menu();
        op = Console.ReadLine();
        switch (op)
        {
            case "1": ej1(); break;
            case "2": ej2(); break;
            case "3": ej3(); break;
            case "13": ej13(); break;
            case "14": ej14(); break;
            case "16": ej16(); break;
            case "0": break;
            default: Console.WriteLine("Opción inválida."); break;
        }
    } while (op != "0");
}

void ej1()
{

    Console.CursorVisible = false;
    ConsoleKeyInfo k = Console.ReadKey(true);
    while (k.Key != ConsoleKey.End)
    {
        Console.Clear();
        Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
        k = Console.ReadKey(true);
    }
    return;
}

void ej2()
{
    double[,] m = initMatrix();
    Console.WriteLine("Imprimiendo:");
    ImprimirMatriz(m);

}

void ej3()
{
    double[,] m = initMatrix();
    ImprimirMatriz(m);
    try
    {
        double[] diagP = GetDiagonalPrincipal(m);
        double[] diagS = GetDiagonalSecundaria(m);
        // double[,] diagonales = new double[,] {{diagP},{diagS}};
        Console.WriteLine("Diagonal Principal: "); ImprimirArreglo(diagP);
        Console.WriteLine("Diagonal Secundaria: "); ImprimirArreglo(diagS);

    }
    catch (ArgumentException)
    {
        Console.WriteLine("La matriz no es cuadrada.");
    }
}

void ej13()
{
    Stack<int> resultado = new Stack<int> {};
    Console.Write("Número en base 10: "); int num = int.Parse(Console.ReadLine());
    Console.Write("Nueva base: "); int numBase = int.Parse(Console.ReadLine());
    while (num > numBase) {
        resultado.Push(num % numBase);
        num /= numBase;
    }
    resultado.Push(num);
    StringBuilder res = new StringBuilder();
    while (resultado.Count > 0) {
        res.Append(resultado.Pop());
    }
    Console.WriteLine($"Conversión a base {numBase}: {res}");
}

void ej14() {
    const string caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
    Dictionary<char, int> mapaLetras = new Dictionary<char, int>();
    for (int i = 0; i < caracteres.Length; i++)
        mapaLetras[caracteres[i]] = i + 1; // ej. primer bucle: mapaLetras['A'] = 0;

    Dictionary<int, char> mapaNums = new Dictionary<int, char>();
    for (int i = 0; i < caracteres.Length; i++)
        mapaNums[i + 1] = caracteres[i];

    string MensajeCifrado(string mensaje, Queue<int> claveParam) {
        StringBuilder msjCifrado = new StringBuilder();
        int numLetra, numClave;

        Queue<int> clave = new Queue<int>(claveParam);

        foreach (char letra in mensaje)
        {
            numLetra = mapaLetras[letra];
            numClave = clave.Dequeue();
            clave.Enqueue(numClave);
            numLetra += numClave;
            if (numLetra > 28)
                numLetra -= 28;
            msjCifrado.Append(mapaNums[numLetra]);
        }
        
        return msjCifrado.ToString();
    }

    string DescifrarMensaje(string mensaje, Queue<int> claveParam) {
        StringBuilder msjCifrado = new StringBuilder();
        int numLetra, numClave;

        Queue<int> clave = new Queue<int>(claveParam);

        foreach (char letra in mensaje)
        {
            numLetra = mapaLetras[letra];
            numClave = clave.Dequeue();
            clave.Enqueue(numClave);
            numLetra -= numClave;
            if (numLetra < 1)
                numLetra += 28;
            msjCifrado.Append(mapaNums[numLetra]);
        }
        
        return msjCifrado.ToString();

    }

    System.Console.WriteLine("Ingrese mensaje a cifrar y una clave: ");

    string? msj = Console.ReadLine().ToUpper();
    if (msj == null)
        throw new ArgumentException("Mensaje no válido.");

    int num;
    System.Console.WriteLine("Ingrese números enteros para la clave (00 para cortar): ");
        Queue<int> colaClave = new Queue<int>();
        num = int.Parse(Console.ReadLine());
        while (num != 00) {
            colaClave.Enqueue(num);
            num = int.Parse(Console.ReadLine());
        }

    System.Console.WriteLine("\nMensaje cifrado: \n");
    System.Console.WriteLine(MensajeCifrado(msj, colaClave));

    System.Console.WriteLine("\nMensaje descifrado: \n");
    System.Console.WriteLine(DescifrarMensaje(msj, colaClave));
}

void ej16() {
    double acum = 0;
    string? input;
    Console.WriteLine("Ingrese números para sumarlos. Línea vacía pa terminar");
    input = Console.ReadLine();
    while(input != "") {
        try {
            acum += double.Parse(input); 
        }
        catch {
            Console.WriteLine("No es un número válido.");
        }
        
        Console.WriteLine($"Acumulado: {acum}");
        Console.WriteLine("Ingrese números para sumarlos. Línea vacía pa terminar");
        input = Console.ReadLine();
    }
}

void Menu()
{
    Console.WriteLine("1. Ej1");
    Console.WriteLine("2. Ej2");
    Console.WriteLine("3. Ej3");
    Console.WriteLine("13. Ej13");
    Console.WriteLine("14. Ej14");
    Console.WriteLine("16. Ej16");
    Console.WriteLine("0. Salir");
    Console.Write("Ingrese una opción: ");
}

double[,] initMatrix()
{
    Console.WriteLine("Dimensiones:");
    Console.Write("Filas: ");
    string? st = Console.ReadLine();
    int f = int.Parse(st);
    Console.Write("Columnas: ");
    st = Console.ReadLine();
    int c = int.Parse(st);
    double[,] arr = new double[f, c];
    int num = 1;
    for (int i = 0; i < f; i++)
    {
        for (int j = 0; j < c; j++)
        {
            arr[i, j] = num; num++;
        }
    }
    return arr;
}

double[] GetDiagonalPrincipal(double[,] matriz)
{
    if (matriz.GetLength(0) == matriz.GetLength(1))
    {

        double[] arr = new double[matriz.GetLength(0)];
        for (int i = 0; i < matriz.GetLength(0); i++) arr[i] = matriz[i, i];
        return arr;

    }
    else throw new ArgumentException("La matriz no es cuadrada");
}

double[] GetDiagonalSecundaria(double[,] matriz)
{
    if (matriz.GetLength(0) == matriz.GetLength(1))
    {

        double[] arr = new double[matriz.GetLength(0)];
        for (int i = matriz.GetLength(0) - 1; i >= 0; i--) arr[i] = matriz[i, i];
        return arr;

    }
    else throw new ArgumentException("La matriz no es cuadrada");
}

void ImprimirMatriz(double[,] m)
{
    for (int i = 0; i < m.GetLength(0); i++)
    {
        for (int j = 0; j < m.GetLength(1); j++)
        {
            Console.Write($"{m[i, j],3} | ");
        }
        Console.WriteLine();
    }
}

void ImprimirArreglo(double[] m)
{
    for (int i = 0; i < m.GetLength(0); i++) Console.Write($"{m[i],3} | ");
    Console.WriteLine();
}
