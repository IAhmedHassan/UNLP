/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public class Circulo extends Figura{
	private double radio;

	public Circulo(double radio, String unCR, String unCL) {
		super(unCR, unCL);
		this.setRadio(radio);
	}

	public double getRadio() {
		return radio;
	}

	private void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * this.getRadio();
	}
	
	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(this.getRadio(),2);
	}

	@Override
	public String toString() {
		return super.toString() + "Radio: " + this.getRadio();
	}
	
	
	
	
}
