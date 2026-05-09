package TP3.Ejercicio6;
import Structures.GeneralTree;

/*
 * Ejercicio 6
 * Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo
 * sucesivamente hasta llegar a cada una de las casas.
 * Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo
 * con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas.
 * 
 * Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
 * public double minimoCaudal(double caudal)
 * que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. 
 * Asuma que la estructura de caños de la red está representada por una variable de instancia de 
 * la clase RedAguaPotable y que es un GeneralTree<Character>.
 */
public class RedDeAguaPotable {
    private GeneralTree<Character> red;

    public double minimoCaudal(double caudal) {
        return 0;
    }
}
