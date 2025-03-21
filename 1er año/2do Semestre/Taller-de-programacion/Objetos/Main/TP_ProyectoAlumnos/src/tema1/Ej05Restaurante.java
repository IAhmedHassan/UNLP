/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1;
import PaqueteLectura.Lector;

/**
 *
 * @author pelo
 */
public class Ej05Restaurante {
    
    public static void main (String[] args) {
        int clientes = 5, i, j;
        int [][] calificaciones = new int [clientes][4];
        System.out.println("RESTAURANTE IL PELINI");
        for (i = 0 ; i < clientes ; i++) {
            
            System.out.println("\nBienvenido, cliente " + (i+1) + "! califique el restaurante del 1 al 10 en los siguientes aspectos: ");
            
            System.out.print("Atención al cliente: ");
            calificaciones[i][0] = Lector.leerInt();
            
            System.out.print("Calidad de la comida: ");
            calificaciones[i][1] = Lector.leerInt();
            
            System.out.print("Precio: ");
            calificaciones[i][2] = Lector.leerInt();
            
            System.out.print("Ambiente: ");
            calificaciones[i][3] = Lector.leerInt();
        }
        
        int [] promedios = new int [4]; int suma;
        for (j = 0; j <4 ; j++) {
            suma = 0;
            for (i = 0; i < clientes ; i++) {
                suma += calificaciones[i][j];           
            }
            promedios[j] = suma / clientes;
        }
        
        System.out.println("PROMEDIOS CALIFICACIONES IL PELINI");
        System.out.println("Atención al cliente: " + promedios[0]);
            
            System.out.println("Calidad de la comida: " + promedios[1]);
            
            System.out.println("Precio: " + promedios[2]);
            
            System.out.println("Ambiente: " + promedios[3]);
    }
    
}
