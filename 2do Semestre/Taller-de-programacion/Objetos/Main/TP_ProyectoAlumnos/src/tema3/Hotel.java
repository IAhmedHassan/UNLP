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
		cantHabitaciones = unNumero;
		habitaciones = new Habitacion[cantHabitaciones];
		GeneradorAleatorio.iniciar();
		for(int i = 0; i < cantHabitaciones; i++) {
			habitaciones[i] = new Habitacion(
				GeneradorAleatorio.generarDouble
				(8000 - 2000 + 1) + 2000);
		}
	}

	public int getCantHabitaciones() {
		return cantHabitaciones;
	}
	
	public void ingresarCliente(int num, Persona ingreso) {
		if (num < cantHabitaciones) {
			habitaciones[num].setCliente(ingreso);	
		}
	}
	
	public Habitacion getHabitacion(int num) {
		return habitaciones[num];
	}
	
}
