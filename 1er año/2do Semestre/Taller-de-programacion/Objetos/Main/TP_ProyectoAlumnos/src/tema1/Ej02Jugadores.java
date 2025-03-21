
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;
        


public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double
        //Paso 3: Crear el vector para 15 double 
        //Paso 4: Declarar indice y variables auxiliares a usar
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        //Paso 7: Calcular el promedio de alturas, informarlo
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        //Paso 9: Informar la cantidad.
        int jugadores = 15;
        double [] vector = new double [jugadores];
        int i, mayProm = 0; double sumaAlturas = 0, promAlturas; 
        for (i = 0 ; i < jugadores ; i++) {
            System.out.print("Ingrese altura " + (i+1) + "° jugador: ");
            vector[i] = Lector.leerDouble();
            sumaAlturas += vector[i]; 
        }
        promAlturas = sumaAlturas / jugadores;
        System.out.println("Promedio de alturas: " + promAlturas);
        
        for (i = 0 ; i < jugadores ; i++) {
            if (vector[i] > promAlturas) {
                mayProm += 1;
            }
        }
        
        System.out.println("Cantidad de jugadores con altura mayor al promedio : " + mayProm);
     
    }
    
}
