namespace Teoria5;
class Familia {
    public Persona? Padre { get; }
    public Persona? Madre { get; }
    public Persona? Hijo { get; }

    public Persona? this[int i] {
        get {
            if (i == 0) return Padre;
            if (i == 1) return Madre;
            if (i == 2) return Hijo;
        }
    }
}
