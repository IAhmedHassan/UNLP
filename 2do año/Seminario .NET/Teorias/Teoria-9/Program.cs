using System.Numerics;

int i = Maximo<int>(100, 55);
Console.WriteLine(i);
string st = Maximo<string>("hola", "mundo");
Console.WriteLine(st);
Console.WriteLine(Maximo<char>('A', 'B'));

T Maximo<T>(T a, T b) where T : IComparable
{
if (a.CompareTo(b) > 0)
{
return a;
}
return b;
}