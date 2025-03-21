/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import tema2.Persona;

/**
 *
 * @author pelo
 */
public class Habitacion {
	private double costoPorNoche;
	private boolean estado;
	private Persona cliente = null;
	
	public Habitacion(double unCostoPorNoche) {
		this.setCostoPorNoche(unCostoPorNoche);
		this.setEstado(true);
	}

	private void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Persona getCliente() {
		if (this.estaLibre()) {	
			System.out.println("La habitación está libre.");
			return null;
		}
		else 
			return this.cliente;
	}
	
	public void ingresarCliente(Persona unCliente) {
		if (this.estaLibre()) {
		this.setCliente(unCliente);
		this.setEstado(false);	
			System.out.println("Cliente ingresado correctamente.");
		} else System.out.println("La habitación ya está ocupada.");
	}
	
	private void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public double getCostoPorNoche() {
		return this.costoPorNoche;
	}
	
	public void aumentarCosto(double unCosto) {
		this.setCostoPorNoche(unCosto + this.getCostoPorNoche());
	}
	
	private void setCostoPorNoche(double unCostoPorNoche) {
		this.costoPorNoche = unCostoPorNoche;
	}
	
	public boolean estaLibre() {
		return this.estado;
	}

	@Override
	public String toString() {
		String estado, infoCliente;
		if (this.estaLibre()) { 
			estado = "libre";
			infoCliente = "";
		}
		else {
			estado = "ocupado";
			infoCliente = ", " + cliente;
		}
		return this.costoPorNoche + ", " + estado + infoCliente;
	}
	
	

	
	
	
	
	
}
