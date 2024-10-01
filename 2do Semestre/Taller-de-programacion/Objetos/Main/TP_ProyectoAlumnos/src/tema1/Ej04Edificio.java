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
public class Ej04Edificio {
    
    public static void main (String[] args) {
        // declarar e inicializar matriz
        int [][] edificio = new int [9][5];
        int piso, oficina;
        for (piso = 1; piso <= 8 ; piso++) {
            for (oficina = 1 ; oficina <= 4 ; oficina++) {
                edificio[piso][oficina] = 0;
            }
        }
        
        System.out.println("Bienvenido al edificio de Pelo. por favor, informe el piso y la oficina a la que quiere ingresar.");
        System.out.print("Piso: ");
        piso = Lector.leerInt();
        while (piso != 9) {
            System.out.print("Oficina: ");
            oficina = Lector.leerInt();
            if (piso <= 8 && oficina <=4 ) {
                edificio[piso][oficina] += 1;
                System.out.println("Ingreso registrado correctamente.");
            }
            else 
                System.out.println("Datos incorrectos. Intente nuevamente.");            
        System.out.print("\n\nPiso: ");
        piso = Lector.leerInt();
        }
        
        for (piso = 1 ; piso <= 8 ; piso++) {
            System.out.println("Piso " + piso);
            for(oficina = 1 ; oficina <= 4 ; oficina++) {
                System.out.println("Oficina " + oficina + ": " + edificio[piso][oficina]);         
            }
            System.out.println("-------");
        }   
        
        // generar llegada de personas (pedir nro de piso y oficina)
        
        // al leerse piso 9, terminar
        
        // informar cantidad de personas que llegaron a cada piso
    }
}
