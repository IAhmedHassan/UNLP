/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
//Paso 1. importar la funcionalidad para generar datos aleatorios

public class Ej03Matrices {
    
//    public static int sumaFila(int fila, int [][] matriz) {
//        
//    } 

    public static void main(String[] args) {
        //Paso 2. iniciar el generador aleatorio
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        //Paso 4. mostrar el contenido de la matriz en consola
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        GeneradorAleatorio.iniciar();
	int [][] matriz = new int [5][5];
        int i,j;
        System.out.println("Nueva matriz: ");
        for (i = 0 ; i < 5 ; i++) {
            for (j = 0; j < 5 ; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(10);
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println("");
        }
        
        int fila = 1, suma = 0;
        for (j = 0 ; j < 5 ; j++) {
            suma += matriz[fila][j]; 
        }
        System.out.println("\nTotal de la fila 1: " + suma);
        
        System.out.println("\nVector de suma de columnas: ");
        int [] sumaCol = new int [5];
        for (j = 0 ; j < 5; j++) {
            suma = 0;
            for (i = 0 ; i < 5 ; i++) {
                suma += matriz[i][j];
            }
            sumaCol[j] = suma;
            System.out.print(sumaCol[j] + " | ");
        }
        
        boolean seguir = true; int num;
        
        while (seguir) {
            boolean noSeEncontro = true;
            System.out.print("\n\ningrese un valor para comprobar su existencia en la matriz: "); 
            num = Lector.leerInt();
            for (i = 0 ; i < 5 ; i++){
                for (j = 0 ; j < 5 ; j++) {
                    if (matriz[i][j] == num) {
                        System.out.println("Número encontrado: Línea " + i + ", columna " + j);
                        noSeEncontro = false;
                    }
                }
            }
            
            if (noSeEncontro) System.out.println("No se encontró el elemento.");
            
            System.out.println("Desea intentar otro numero? (true/false): ");
            seguir = Lector.leerBoolean();
        }
        

        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".

    }
}
