package TP3.Parciales;
import Structures.GeneralTree;
import java.util.List;

/*
 * Clase para agrupar los ejercicios de parciales del TP3 (9, 10, 11)
 */
public class ParcialArboles {

    /*
     * Ejercicio 9
     * Implemente en la clase ParcialArboles el método:
     * public static boolean esDeSeleccion (GeneralTree<Integer> arbol)
     * que devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es.
     * Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos.
     */
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        return false;
    }

    /*
     * Ejercicio 10
     * Implemente el método: public static List<Integer> resolver(GeneralTree<Integer> arbol)
     * que recibe un árbol general de valores enteros (0 o 1) y devuelve una lista con los
     * valores que componen el “camino filtrado de valor máximo”.
     * Se filtran los 0. El valor máximo es la suma de (valor * nivel).
     */
    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        return null;
    }

    /*
     * Ejercicio 11
     * Implemente el método: public static boolean esCreciente(GeneralTree<Integer> arbol)
     * que devuelve true si el árbol es creciente.
     * Un árbol general es creciente si para cada nivel la cantidad de nodos es igual a 
     * la cantidad de nodos del nivel anterior + 1.
     */
    public static boolean esCreciente(GeneralTree<Integer> arbol) {
        return false;
    }
}
