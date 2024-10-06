/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author pelo
 */
public class Ej03Casting {
        
    public static void main (String[] args) {
        int cupo = 0, dia = 0, turno = 0, edad, DNI;
        String nombre;
        Persona [][] TurnosCasting = new Persona [5][8];
        
        System.out.print("Nombre:");
        nombre = Lector.leerString();
        while (cupo <= 40  && !(nombre.equals("ZZZ"))) {
            System.out.print("DNI:");
            DNI = Lector.leerInt();
            System.out.print("Edad:");
            edad = Lector.leerInt();
            
            TurnosCasting[dia][turno] = new Persona(nombre,DNI,edad);
            System.out.println("\nTURNO ASIGNADO.\nDIA: " + dia + "\nTURNO: " + turno);
            
            if (turno > 8) {
                turno = 0;
                dia++;
            }
            
            System.out.print("Nombre:");
            nombre = Lector.leerString();
        }
        
        for(dia = 0 ; dia < 5 ; dia++ ) {
            for (turno = 0 ; turno < 8 ; turno++ ) {
                System.out.println(
                        "DIA " + dia + 
                        ", TURNO " + turno +
                        ": " + TurnosCasting[dia][turno].getNombre()
                );
            }
        }
    }
}
