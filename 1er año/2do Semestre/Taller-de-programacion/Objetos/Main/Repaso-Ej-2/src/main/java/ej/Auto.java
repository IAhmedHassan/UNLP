/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej;

/**
 *
 * @author pelo
 */
public class Auto {
	
	private String nombreDueño;
	private String patente;
	
	public Auto(String unNombre, String unaPatente) {
		this.setNombreDueño(unNombre);
		this.setPatente(unaPatente);
	}

	private String getNombreDueño() {
		return nombreDueño;
	}

	private void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public String getPatente() {
		return patente;
	}

	private void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public String toString() {
		return "Patente: " + this.getPatente() + ", dueño: " + this.getNombreDueño(); 
	}
	
	
	
	
}
