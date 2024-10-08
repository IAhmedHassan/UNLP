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
public class Ej04Hotel {
	public static void main(String[] args) {
		Hotel h = new Hotel(5);
		h.asignarHabitacion(1, new Persona("Ignacio Ahmed Hassan", 41294714, 26));
		h.asignarHabitacion(2, new Persona("Camila Gomez", 40339739, 27));
		
		System.out.println(h);
		
		h.subirPrecios(30);
		
		System.out.println(h);
	}
}
