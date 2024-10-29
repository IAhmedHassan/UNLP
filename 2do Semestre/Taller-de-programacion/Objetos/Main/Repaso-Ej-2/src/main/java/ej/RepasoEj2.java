/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ej;

/**
 *
 * @author pelo
 */
public class RepasoEj2 {

    public static void main(String[] args) {
        Estacionamiento e = new Estacionamiento("Garage de Pelo", "26, 46 y 47", "8:00", "21:00", 3, 3);
		
		Auto a1, a2, a3, a4, a5, a6;
		
		a1 = new Auto("Pelo", "MOQ 616");
		a2 = new Auto("Cami", "AF 541 WS");
		a3 = new Auto("Fausto", "AD 123 FS");
		a4 = new Auto("Betite", "ASD 123");
		a5 = new Auto("Anita", "PDO 321");
		a6 = new Auto("Sofia", "QLO 456");
		
		e.registrarAuto(a1, 1, 1);
		e.registrarAuto(a2, 2, 1);
		e.registrarAuto(a3, 3, 1);
		e.registrarAuto(a4, 1, 2);
		e.registrarAuto(a5, 2, 3);
		e.registrarAuto(a6, 1, 3);

		System.out.println(e);
		
		System.out.println("Cantidad de autos en plaza 1: " + e.CantAutosEnPlaza(1));
		
		System.out.println("Leyendo... MOQ 616");
		System.out.println(e.encontrarAutoPorPatente("MOQ 616"));
		
		
    }
}
