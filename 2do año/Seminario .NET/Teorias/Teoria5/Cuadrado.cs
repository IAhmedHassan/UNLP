namespace Teoria5;
class Cuadrado {
    private double _lado;
//     public void SetLado(double value) => _lado = value;
//     public double GetLado() => _lado;
//     public double GetArea() => _lado * _lado;
    public double Lado {

        get {
            return Lado;
        }

        private set =>
            _lado = (value > 100) ? 100
                  : (value < 0) ? 0
                  : value;
    }

    public double Area {
        get => _lado * _lado;
    }
    public Cuadrado(double unLado) {
        this.Lado = unLado;
    }

}