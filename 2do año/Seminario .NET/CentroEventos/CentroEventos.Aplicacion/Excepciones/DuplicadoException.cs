namespace CentroEventos.Aplicacion.Excepciones;
public class DuplicadoException : Exception {

    public DuplicadoException() { }

    public DuplicadoException(string message): base(message) { }

    public DuplicadoException(string message,Exception inner): base(message, inner) { }
}
