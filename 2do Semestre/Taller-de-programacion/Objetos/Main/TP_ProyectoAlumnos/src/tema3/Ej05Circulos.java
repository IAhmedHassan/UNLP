/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import PaqueteLectura.Lector;

/**
 *
 * @author pelo
 */
public class Ej05Circulos {
	
	public static void main(String[] args) {
		System.out.println("PROGRAMA PA GENERAR CIRCULOS\n");
		System.out.print("ingrese un radio: ");
		double unRadio = Lector.leerDouble();
		System.out.print("Color de línea: ");
		String unColorDeLinea = Lector.leerString();
		System.out.print("Color de Relleno: ");
		String unRelleno = Lector.leerString();
		
		Circulo unCirculo = new Circulo(unRadio, unRelleno, unColorDeLinea);
		
		System.out.println("Area del círculo: " + String.format("%.2f",unCirculo.calcularArea()));
		
		System.out.println("Perímetro del círculo: " + String.format("%.2f", unCirculo.calcularPerimetro()));
		
	}
}
