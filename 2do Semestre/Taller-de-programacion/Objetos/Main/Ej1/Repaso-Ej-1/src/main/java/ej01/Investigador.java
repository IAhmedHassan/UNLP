/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej01;

/**
 *
 * @author pelo
 */

public class Investigador {
	private String nombre;
	private int categoria;
	private String Especialidad;
	private Subsidio[] subsidios;
	private int cantSubsidios;
	
	public Investigador(String unNombre, int unaCategoria, String unaEspecialidad) {
		this.setNombre(unNombre);
		this.setCategoria(unaCategoria);
		this.setEspecialidad(unaEspecialidad);
		this.initProyectos();
	}
	
	public void solicitarSubsidio(double unMonto , String unMotivo) {
		if (this.getCantSubsidios() < 5) {
			Subsidio unSubsidio = new Subsidio(unMonto, unMotivo);
			this.agregarSubsidio(unSubsidio);
		} else System.out.println(this.getNombre() + 
			" ya alcanzó la cantidad máxima de subsidios disponible.");
	}
	
	public void otorgarTodos() {
		for (int i = 0 ; i < this.getCantSubsidios() ; i++) {
			this.otorgarSubsidio(i);
		}
	}
	
	public void otorgarSubsidio(int numeroSubsidio) {
		this.subsidios[numeroSubsidio].otorgar();
	}
	
	public double informarTotalSubsidiosOtorgados() {
		double total = 0;
		for (int i = 0 ; i < this.getCantSubsidios() ; i++) {
			if (this.subsidios[i].fueOtorgado()) {
				total += this.subsidios[i].getMonto();
			}
		}
		
		return total;
	}
	
	private void agregarSubsidio(Subsidio unSubsidio) {
		int s = this.getCantSubsidios();
		this.subsidios[s] = unSubsidio;
		this.setCantSubsidios(s + 1);
	}
	
	private void initProyectos() {
		subsidios = new Subsidio[5];
		for(int i = 0 ; i < 5 ; i++){
			subsidios[i] = null;
		}
		this.setCantSubsidios(0);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getCategoria() {
		return categoria;
	}

	private void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	private String getEspecialidad() {
		return Especialidad;
	}

	private void setEspecialidad(String Especialidad) {
		this.Especialidad = Especialidad;
	}

	private int getCantSubsidios() {
		return cantSubsidios;
	}

	private void setCantSubsidios(int cantSubsidios) {
		this.cantSubsidios = cantSubsidios;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", categoría " + this.getCategoria() +
				", " + this.getEspecialidad() + ", $" + String.format("%.2f", this.informarTotalSubsidiosOtorgados()) + " otorgados";
	}
	
	
	
	
}
