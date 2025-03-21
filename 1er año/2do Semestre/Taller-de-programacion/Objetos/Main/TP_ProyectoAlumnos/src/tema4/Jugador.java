
package tema4;

/**
 *
 * @author pelo
 */
public class Jugador extends Empleado{
	private int partidosJugados, golesAnotados;

	public Jugador(int cantPartidosJugados, int cantGolesAnotados, String unNombre, double unSueldo, int unaAntiguedad) {
		super(unNombre, unSueldo, unaAntiguedad);
		this.setPartidosJugados(cantPartidosJugados);
		this.setgolesAnotados(cantGolesAnotados);
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	private void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getGolesAnotados() {
		return golesAnotados;
	}

	private void setgolesAnotados(int cantGolesAnotados) {
		this.golesAnotados = cantGolesAnotados;
	}
	
	@Override
	public double calcularEfectividad() {
		return this.getGolesAnotados() / this.getPartidosJugados();
	}
	
	@Override
	public double calcularSueldoACobrar() {
		double aux = super.calcularSueldoACobrar();
		
		if (this.calcularEfectividad() > 0.5) {
			aux += this.getSueldo();
		}
		return aux;
	}
	
	
	
	
}
