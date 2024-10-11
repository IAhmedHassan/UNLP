/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public class Triangulo extends Figura{
	private double lado1, lado2, lado3;
	
	public Triangulo(double lado1, double lado2, double lado3, String unColorR, String unColorL) {
		super(unColorR, unColorL);
		this.setLado1(lado1);
		this.setLado2(lado2);
		this.setLado3(lado3);
	}

	public double getLado1() {
		return this.lado1;
	}

	public double getLado2() {
		return this.lado2;
	}

	public double getLado3() {
		return this.lado3;
	}

	private void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	private void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	private void setLado3(double lado3) {
		this.lado3 = lado3;
	}
	
	@Override
	public double calcularPerimetro() {
		return this.getLado1() + this.getLado2() + this.getLado3();
	}
	
	@Override
	public double calcularArea() {
	double s = (lado1 + lado2 + lado3) / 2;
	return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

	@Override
	public String toString() {
		return super.toString() +
				"Lado 1: " + this.getLado1() + " " +
				"Lado 2: " + this.getLado2() + " " +
				"Lado 3: " + this.getLado3();

	}
	
	
	
	
}
