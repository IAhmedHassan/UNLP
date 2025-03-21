/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public abstract class Recital {
	private String nombreBanda;
	private String[] listadeTemas;
	private int cantidadDeTemas;
	private int maxTemas;
	
	public Recital(String unNombreBanda, int cantidadDeCanciones) {
		this.setNombreBanda(unNombreBanda);
		this.innitListaTemas(cantidadDeCanciones);
		
	}
	
	private void innitListaTemas(int cantidadDeCanciones) {
		this.setCantidadDeTemas(0);
		this.setMaxTemas(cantidadDeCanciones);
		this.listadeTemas = new String[this.getMaxTemas()];
		
		for (int i = 0 ; i < this.getMaxTemas() ; i++) {
			this.listadeTemas[i] = null;
		}
	}
	
	public abstract double calcularCosto();
	
	public void actuar() {
		for (int i = 0 ; i <= this.getCantidadDeTemas(); i++) {
			System.out.println("Y ahora tocaremos " + this.listadeTemas[i] + "!");
		}
	}
	
	public void agregarTema(String unNombredeTema) {
		if (this.getCantidadDeTemas() < this.getMaxTemas()) {
			this.listadeTemas[this.getCantidadDeTemas()] = unNombredeTema;
			this.setCantidadDeTemas(this.getCantidadDeTemas() +1);
		
		} else System.out.println("Ya se alcanzó el máximo de temas.");
	}

	private int getMaxTemas() {
		return this.maxTemas;
	}

	private void setMaxTemas(int maxTemas) {
		this.maxTemas = maxTemas;
	}

	public String getNombreBanda() {
		return this.nombreBanda;
	}

	private void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	private int getCantidadDeTemas() {
		return this.cantidadDeTemas;
	}

	private void setCantidadDeTemas(int cantidadDeTemas) {
		this.cantidadDeTemas = cantidadDeTemas;
	}
	
	
}
