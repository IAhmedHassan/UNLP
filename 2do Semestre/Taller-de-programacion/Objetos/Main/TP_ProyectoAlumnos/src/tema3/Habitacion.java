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
	private Persona cliente;
	
	public Habitacion(double unCostoPorNoche) {
		this.setCostoPorNoche(unCostoPorNoche);
		this.setEstado(true);
		this.setCliente(null);
	}

	public void setEstado(boolean estado) {
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

	public void setCliente(Persona cliente) {
		if (this.estaLibre()) {
		this.cliente = cliente;
		this.setEstado(false);	
			System.out.println("Cliente ingresado correctamente.");
		} else System.out.println("La habitación ya está ocupada.");
	}

	public double getCostoPorNoche() {
		return this.costoPorNoche;
	}

	public void setCostoPorNoche(double unCostoPorNoche) {
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
