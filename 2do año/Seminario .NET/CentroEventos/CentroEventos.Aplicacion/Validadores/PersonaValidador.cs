namespace CentroEventos.Aplicacion.Validadores;
using System.Text;
using Entidades;
using Interfaces;


public class PersonaValidador(IRepositorioPersona repoP, IRepositorioEventoDeportivo repoED, IRepositorioReserva repoR)
{
    public bool ValidarConstruccion(Persona p, out string mensajeError)
    {
        StringBuilder mensaje = new StringBuilder("");

        if (string.IsNullOrWhiteSpace(p.Nombre))
        {
            mensaje.Append("El nombre no puede estar vacío o ser null.\n");
        }

        if (string.IsNullOrWhiteSpace(p.Apellido))
        {
            mensaje.Append("El apellido no puede estar vacío o ser null.\n");
        }

        if (string.IsNullOrWhiteSpace(p.Dni))
        {
            mensaje.Append("El DNI no puede estar vacío o ser null.\n");
        }

        if (string.IsNullOrWhiteSpace(p.Email))
        {
            mensaje.Append("El email no puede estar vacío o ser null.\n");
        }

        mensajeError = mensaje.ToString();
        return mensajeError == "";
    }

    public bool ValidarDuplicado(Persona p, out string mensajeError)
    {
        StringBuilder mensaje = new StringBuilder("");

        if (repoP.DniExiste(p.Dni))
        {
            mensaje.Append($"El DNI {p.Dni} ya existe.\n");
        }

        if (repoP.EmailExiste(p.Email))
        {
            mensaje.Append($"El Email {p.Email} ya existe.");
        }

        mensajeError = mensaje.ToString();
        return mensajeError == "";
    }

    public bool ValidarDuplicadoModificar(Persona p, out string mensajeError)
    {
        // en este punto la persona existe y la modificación está bien construida:
        // pedir lista de personas y borrar la que se quiere modificar.
        // comparar contra esa lista.
        // si no hay duplicado enviar persona a modificar.
        // modificar se encarga de insertar la persona modificada en el lugar correcto. 
        
        StringBuilder mensaje = new StringBuilder("");
        var lista = repoP.ListarPersonas().Where(per => per.Id != p.Id);

        if (lista.Any(per => per.Email == p.Email))
            mensaje.Append($"El Email {p.Email} ya existe.");

        if (lista.Any(per => per.Dni == p.Dni))
            mensaje.Append($"El DNI {p.Dni} ya existe.");

        mensajeError = mensaje.ToString();
        return mensajeError == "";
    }

    public bool ValidarReglas(int id, out string mensajeError)
    {
        StringBuilder mensaje = new StringBuilder("");

        if (repoR.PersonaTieneReserva(id))
            mensaje.Append($"La persona ID {id} está registrada en una reserva.\n");

        if (repoED.PersonaEsResponsable(id))
            mensaje.Append($"La persona ID {id} es responsable de un evento.");

        mensajeError = mensaje.ToString();
        return mensajeError == "";
    }

}
