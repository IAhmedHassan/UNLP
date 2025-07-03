using Teoria_7;

IImprimible[] vector = [
       new Moto("Zanella"),
       new Empleado("Juan"),
       new Moto("Gilera"),
       
   ];

for (int i = 0; i < vector.Length; i++) {
    vector[i].Imprimir();
}

/*
foreach (IImprimible o in vector)
{
    o.Imprimir();
    //Esto no es polimórfico
    // if (o is Empleado e) {
    //     e.Imprimir();
    // }
    // else if (o is Moto m) {
    //     m.Imprimir();
    // }
}
*/