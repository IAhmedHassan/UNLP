/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public class Fecha {
	private int dia;
	private int mes;
	private int año;
	
	// Constructor

	public Fecha(int dia, int mes, int año) {
		this.setDia(dia);
		this.setMes(mes);
		this.setAño(año);
	}
	
	
	
	
	// Getters
	
	private int getDia() {
		return dia;
	}

	private int getMes() {
		return mes;
	}

	private int getAño() {
		return año;
	}
	
	// Setters
	
	private void setDia(int dia) {
		this.dia = dia;
	}

	private void setMes(int mes) {
		this.mes = mes;
	}

	private void setAño(int año) {
		this.año = año;
	}

	@Override
	public String toString() {
		return this.getDia() + "/" + this.getMes() + "/" + this.getAño();
		
	}
	
	
	
}
