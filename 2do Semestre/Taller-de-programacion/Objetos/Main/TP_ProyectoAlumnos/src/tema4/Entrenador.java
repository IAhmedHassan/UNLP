package tema4;

/**
 *
 * @author pelo
 */
public class Entrenador extends Empleado{
	private int campeonatosGanados;

	public Entrenador(int cantCampeonatosGanados, String unNombre, double unSueldo, int unaAntiguedad) {
		super(unNombre, unSueldo, unaAntiguedad);
		this.setCampeonatosGanados(cantCampeonatosGanados);
	}
	
	public int getCampeonatosGanados() {
		return campeonatosGanados;
	}

	private void setCampeonatosGanados(int cantCampeonatosGanados) {
		this.campeonatosGanados = cantCampeonatosGanados;
	}	
	
	@Override
	public double calcularEfectividad() {
		return this.getCampeonatosGanados() / this.getAntiguedad();
	}
	
	@Override
	public double calcularSueldoACobrar() {
		double aux = super.calcularSueldoACobrar();
		
		switch (this.getCampeonatosGanados()) {
			case 0: break;
			case 1: case 2:case 3: case 4:
				aux+= 5000;
				break;
			case 5: case 6: case 7: case 8: case 9: case 10:
				aux+= 30000;
				break;
			default:
				aux += 50000;
				break;
		}
		return aux;
	}
	
	
	
}
