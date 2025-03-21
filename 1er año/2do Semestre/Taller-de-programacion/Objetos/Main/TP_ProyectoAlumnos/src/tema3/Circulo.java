package tema3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pelo
 */
public class Circulo {
	private double radio;
	private String relleno;
	private String colorLinea;
	
	public Circulo(double unRadio, String unRelleno, String unColorDeLinea) {
		this.setColorLinea(unColorDeLinea);
		this.setRadio(unRadio);
		this.setRelleno(unRelleno);
	}

	public double getRadio() {
		return radio;
	}

	private void setRadio(double unRadio) {
		this.radio = unRadio;
	}

	public String getRelleno() {
		return relleno;
	}

	private void setRelleno(String unRelleno) {
		this.relleno = unRelleno;
	}

	public String getColorLinea() {
		return colorLinea;
	}

	private void setColorLinea(String unColorLinea) {
		this.colorLinea = unColorLinea;
	}
	
	public double calcularPerimetro() {
		return 2 * Math.PI * this.getRadio();
	}
	
	public double calcularArea() {
		return Math.PI * Math.pow(this.getRadio(),2);
	}
	
}
