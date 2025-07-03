namespace Teoria_8;

class ComparadorPorLegajo : System.Collections.IComparer {
    public int Compare(object? x, object? y) {
        int result = 1;
        if (x is Empleado e1 && y is Empleado e2)
        {
            int legajo1 = e1.Legajo;
            int legajo2 = e2.Legajo;
            result = legajo1.CompareTo(legajo2);
        }
        return result;
    }

}