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
public class Ej02Crear15Personas {
    
    public static void main(String[] args) {
        System.out.print("PROGRAMA PA GENERAR PERSONAS");
        int i = 0, cantPersonas = 15, edad, DNI;
        String nombre;
        Persona vectorPersonas[] = new Persona[cantPersonas];

        System.out.print("\n\nEdad: ");
        edad = Lector.leerInt();
        
        while (i < cantPersonas && edad != 0) {
            
            System.out.print("Nombre: ");
            nombre = Lector.leerString();
            System.out.print("DNI: ");
            DNI = Lector.leerInt();
            
            vectorPersonas[i] = new Persona(nombre,DNI,edad);
            i++;
            System.out.print("Edad: ");
            edad = Lector.leerInt();
        }
        int cantJubilados = 0; Persona masViejo = vectorPersonas[0];
        System.out.print("\n\n");
        
        for (i = 0 ; i < cantPersonas ; i++) {
            if (vectorPersonas[i].getEdad() >= 65)
                cantJubilados++;
            if (vectorPersonas[i].getDNI() < masViejo.getDNI())
                masViejo = vectorPersonas[i];
            
            System.out.println("Cantidad de jubilados: " + cantJubilados);
            System.out.println("Quién es el más viejo?\n" + masViejo.toString());
        }
    }
    
}
