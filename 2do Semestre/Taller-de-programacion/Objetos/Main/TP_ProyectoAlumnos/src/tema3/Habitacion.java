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
	private boolean estaLibre;
	private Persona cliente;
	
	public Habitacion(double unCostoPorNoche) {
		this.costoPorNoche = unCostoPorNoche;
		estaLibre = true;
	}

	public Persona getCliente() {
		if (estaLibre) {	
			System.out.println("La habitación está libre.");
			return null;
		}
		else 
			return this.cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
		this.estaLibre = false;
	}

	public double getCostoPorNoche() {
		return costoPorNoche;
	}

	public void setCostoPorNoche(double costoPorNoche) {
		this.costoPorNoche = costoPorNoche;
	}

	
	
	
	
	
}
