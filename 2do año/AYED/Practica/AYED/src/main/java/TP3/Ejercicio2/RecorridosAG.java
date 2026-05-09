package TP3.Ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import Structures.GeneralTree;
import Structures.Queue;

/*
 * Ejercicio 2
 * a) Implemente en la clase RecorridosAG los siguientes métodos:
 * 
 * public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n)
 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 * pasados como parámetros, recorrido en preorden.
 * 
 * public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n)
 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 * pasados como parámetros, recorrido en inorden.
 * 
 * public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n)
 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 * pasados como parámetros, recorrido en postorden.
 * 
 * public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n)
 * Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 * pasados como parámetros, recorrido por niveles.
 *
 * b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones
 * haría tanto en la firma como en la implementación de los mismos?
 */
public class RecorridosAG {
    
    private static boolean cumple(int n, int baseN) {
        return n % 2 != 0 && n > baseN; 
    }
    
    // pre-orden
    
    public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n) {
        LinkedList<Integer> l = new LinkedList<>(); 
        if (a != null && !a.isEmpty()) numerosImparesMayoresQuePreOrdenRecursivo(a, n, l);
        return l;
    }
    
    
    private static void numerosImparesMayoresQuePreOrdenRecursivo(GeneralTree<Integer> a, Integer n, LinkedList<Integer> l) {
        if (cumple(a.getData(), n)) l.add(a.getData());

        for(GeneralTree<Integer> child : a.getChildren())
            numerosImparesMayoresQuePreOrdenRecursivo(child, n, l);
        
    }

    // in-orden

    public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n) {
        
        LinkedList<Integer> l = new LinkedList<>();
        if (a != null && !a.isEmpty()) numerosImparesMayoresQueInOrdenRecursivo(a, n, l);
        return l;
    }

    private static void numerosImparesMayoresQueInOrdenRecursivo(GeneralTree<Integer> a, Integer n, LinkedList<Integer> l) {
        
        if(a.hasChildren()){
            GeneralTree<Integer> firstChild = a.getChildren().getFirst();
            numerosImparesMayoresQueInOrdenRecursivo(firstChild, n, l);
        } 
        if (cumple(a.getData(), n)) l.add(a.getData());

        if (a.hasChildren()) {

            Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
            it.next();
            while (it.hasNext()) {
                numerosImparesMayoresQueInOrdenRecursivo(it.next(), n, l);
            }
        }
    }
    
    // post-orden

    public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        LinkedList<Integer> l= new LinkedList<>();
        if (a != null && !a.isEmpty()) numerosImparesMayoresQuePostOrdenRecursivo(a, n, l);
        return l;
    }
    
    private static void numerosImparesMayoresQuePostOrdenRecursivo(GeneralTree<Integer> a, Integer n, LinkedList<Integer> l) {
        for(GeneralTree<Integer> child : a.getChildren()) numerosImparesMayoresQuePostOrdenRecursivo(child, n, l);

        if (cumple(a.getData(),n)) l.add(a.getData());
    }

    // por niveles

    public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
        LinkedList<Integer> l = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            Queue<GeneralTree<Integer>> q = new Queue<>();
            q.enqueue(a);
            // q.enqueue(null);
            while (!q.isEmpty() ) {
                GeneralTree<Integer> gt = q.dequeue();
                if (cumple(gt.getData(), n)) l.add(gt.getData());
                for (GeneralTree<Integer> child : gt.getChildren())
                    q.enqueue(child);
            }
        }

        return l;
    }

}
