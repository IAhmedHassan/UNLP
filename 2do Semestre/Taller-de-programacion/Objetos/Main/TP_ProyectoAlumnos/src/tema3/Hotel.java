/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author pelo
 */

import PaqueteLectura.GeneradorAleatorio;
import tema2.Persona;

public class Hotel {
	private int cantHabitaciones;
	private final Habitacion[] habitaciones;
	
	public Hotel(int unNumero) {
		this.setCantHabitaciones(unNumero);
		habitaciones = new Habitacion[this.getCantHabitaciones()];
		GeneradorAleatorio.iniciar();
		for(int i = 0; i < this.getCantHabitaciones(); i++) {
			habitaciones[i] = new Habitacion(
				GeneradorAleatorio.generarDouble
				(8000 - 2000 + 1) + 2000);
		}
	}

	public int getCantHabitaciones() {
		return cantHabitaciones;
	}

	private void setCantHabitaciones(int unaCantHabitaciones) {
		this.cantHabitaciones = unaCantHabitaciones;
	}
	
	
	public void ingresarCliente(int num, Persona ingreso) {
		if (num < this.getCantHabitaciones()) {
			if (this.habitaciones[num].estaLibre()) {
				habitaciones[num -1].setCliente(ingreso);	
			}	
			else System.out.println("La habitación no está disponible.");
		} else System.out.println("La habitación no existe.");
	}
	
	public Habitacion getHabitacion(int num) {
		return this.habitaciones[num];
	}
	
	public void subirCosto(double unMonto) {
		for (int i = 0; i < this.getCantHabitaciones(); i++) {
			habitaciones[i].setCostoPorNoche(
				habitaciones[i].getCostoPorNoche() + unMonto);
		}
}

	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < getCantHabitaciones(); i++) {
			aux += "Habitación " + (i+1) + ": $" + this.habitaciones[i] + "\n";
		}
		return aux;
	}
	
	
	
}
