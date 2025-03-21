/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author pelo
 */
public class Ej01TriangulosYCirculos {
	
	public static void main(String[] args) {

		String color1 = "rojo";
		String color2 = "amarillo";
		String color4 = "verde";
		String color3 = "azul";

		Circulo o = new Circulo(4, color1, color2);
		Triangulo t = new Triangulo(1, 1, 1, color3, color4);
		
		System.out.println(o);
		System.out.println(t);
		
		o.despintar();
		t.despintar();
		
		System.out.println(o);
		System.out.println(t);
		

	}
	
}
