var personas = Persona.GetLista();
personas.ForEach(p => Console.WriteLine(p));
personas.Where(p => p.Edad > 18)
    .ToList()
    .ForEach(p => Console.WriteLine(p));