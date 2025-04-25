class Cuenta {
   static int s_cantCuentas;
   static int s_depositos;
   static int s_extracciones;
   static double s_totalDepositado;
   static double s_totalExtraido;
   static int s_fallos; 
   static int s_totalSaldo;
   static List<Cuenta> s_lista = new List<Cuenta>();
   int _saldo;
   int _id;

   public Cuenta() {
        _saldo = 0;
        s_cantCuentas++;
        _id = s_cantCuentas;
        s_lista.Add(this);
        Console.WriteLine($"Nueva cuenta creada. id = {_id}");
   }

   public Cuenta Depositar(int monto) {
        _saldo += monto;
        s_totalDepositado += monto;
        s_depositos++;
        s_totalSaldo += monto;
        Console.WriteLine($"Se depositó {monto} en la cuenta {this._id} (Saldo={this._saldo})");
        return this;
   }

   public Cuenta Extraer(int monto) {
        if (monto <= _saldo) {
            _saldo -= monto;
            s_totalExtraido += monto;
            s_extracciones++;
            s_totalSaldo -= monto;
            Console.WriteLine($"Se extrajo {monto} de la cuenta {this._id} (Saldo={this._saldo})");
        }
        else {
            s_fallos++;
            Console.WriteLine("No te alcanza gato");
        }

        return this;
   }

   public static void ImprimirDetalle() {
        Console.WriteLine("DETALLE");
        Console.WriteLine($"{"-Cuentas Creadas:",-20}{s_cantCuentas,3}");
        Console.WriteLine($"{"-Depósitos:",-20} {s_depositos,3}");
        Console.WriteLine($"{"-Extracciones:",-20} {s_extracciones,3}");
        Console.WriteLine($"{"-Total Depositado:",-20} ${s_totalDepositado,10}");
        Console.WriteLine($"{"-Total Extraído: ",-20}${s_totalExtraido,10}");
        Console.WriteLine($"{"-Saldo:",-20} ${s_totalSaldo,10}");
        Console.WriteLine($"\n\t* Se denegaron {s_fallos} extracciones por falta de fondos.");
        
   }

   public static List<Cuenta> GetCuentas(){
     List<Cuenta> cuentas= new List<Cuenta> ();
     foreach (Cuenta cuenta in s_lista) {
        cuentas.Add(cuenta);
     }
     return cuentas;
   }
}