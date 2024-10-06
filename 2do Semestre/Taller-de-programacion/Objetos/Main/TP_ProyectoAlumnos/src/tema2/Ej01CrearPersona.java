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
public class Ej01CrearPersona {
    
    public static Persona CrearPersona() {
        System.out.print("Nombre:");
        String nombre = Lector.leerString();
        System.out.print("DNI:");
        int DNI = Lector.leerInt();
        System.out.print("Edad:");
        int edad = Lector.leerInt();
        Persona nuevaPersona = new Persona(nombre,DNI,edad);  
        return nuevaPersona;
    }
    
    public static void main(String[] args) {
   
        Persona Pelo = CrearPersona();
        
        System.out.print(Pelo.toString());
    }
}
