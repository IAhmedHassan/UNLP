/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public abstract class Empleado {
	
	private String nombre;
	private double sueldo;
	private int antiguedad;

	public Empleado(String unNombre, double unSueldo, int unaAntiguedad) {
		this.setNombre(unNombre);
		this.setSueldo(unSueldo);
		this.setAntiguedad(unaAntiguedad);
	}
	
	public abstract double calcularEfectividad();
	
	
	public double calcularSueldoACobrar() {
		return this.getSueldo() + (0.10 * this.getAntiguedad());
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + "\n" +
				"Sueldo a cobrar: " + this.calcularSueldoACobrar() + "\n" +
				"Efectividad: " + this.calcularEfectividad();
	}
	
	

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	private void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	private void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
}
