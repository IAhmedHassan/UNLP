/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public class Gira extends Recital{
	private String nombreGira;
	private FechaGira[] fechas;
	private int actual;
	private int cantFechas;
	private int maxFechas;

	public Gira(String nombreGira, String unNombreBanda, int cantidadDeCanciones, int cantidadFechas) {
		super(unNombreBanda, cantidadDeCanciones);
		this.setNombreGira(nombreGira);
		this.innitFechas(cantidadFechas);
	}
	
	public void agregarFecha(fechaGira unaFecha) {
		if (this.getCantFechas() < this.getMaxFechas() ) {
			this.fechas[this.getCantFechas()] = unaFecha;
			this.setCantFechas(this.getCantFechas() + 1);
		}
	}
	
	@Override
	public double calcularCosto() {
		return this.getCantFechas() * 30000.0;
	}
	
	@Override
	public void actuar() {
		FechaGira fechaActual = this.fechas[this.getActual()];
		System.out.println("Buenas noches, " + fechaActual.getCiudad() + "!");
		super.actuar();
	}
	
	private void innitFechas(int largoGira) {
		this.setMaxFechas(largoGira);
		this.setCantFechas(0);
		this.setActual(0);
		this.fechas = new FechaGira[this.getMaxFechas()];
		
		for (int i = 0 ; i < this.getMaxFechas() ; i++) {
			this.fechas[i] = null;
		}
		
	}

	private int getActual() {
		return actual;
	}

	private int getCantFechas() {
		return cantFechas;
	}

	private int getMaxFechas() {
		return maxFechas;
	}

	public String getNombreGira() {
		return nombreGira;
	}
	
	
	
	// setters

	private void setCantFechas(int cantFechas) {
		this.cantFechas = cantFechas;
	}

	private void setMaxFechas(int maxFechas) {
		this.maxFechas = maxFechas;
	}

	private void setActual(int actual) {
		this.actual = actual;
	}

	private void setNombreGira(String nombreGira) {
		this.nombreGira = nombreGira;
	}
	
	
	
	
	
}
