/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public class Trabajador extends Persona{
	private String trabajo;

	public Trabajador(String unTrabajo, String unNombre, int unDNI, int unaEdad) {
		super(unNombre, unDNI, unaEdad);
		this.setTrabajo(unTrabajo);
	}

	public String getTrabajo() {
		return this.trabajo;
	}

	private void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public String toString() {
		return super.toString() + "Soy " + this.getTrabajo() + ".";
	}
	
	
}
