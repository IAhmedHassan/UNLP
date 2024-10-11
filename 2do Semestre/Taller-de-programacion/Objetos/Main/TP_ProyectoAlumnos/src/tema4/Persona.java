/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public class Persona {
	private String nombre;
	private int DNI;
	private int edad;
	
	public Persona(String unNombre, int unDNI, int unaEdad) {
		this.setNombre(unNombre);
		this.setEdad(unaEdad);
		this.setDNI(unDNI);
}

	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getDNI() {
		return this.DNI;
	}

	private void setDNI(int DNI) {
		this.DNI = DNI;
	}

	private int getEdad() {
		return this.edad;
	}

	private void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Mi nombre es " + this.getNombre() + 
				", mi DNI es " + this.getDNI() +
				" y tengo " + this.getEdad() + " años.";
	}
	
}
