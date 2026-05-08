package TP2.Ejercicio5;

/*
Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de
instancia un árbol binario de números enteros y un método de instancia
sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol
que se encuentren a la profundidad pasada como argumento.
 */

import TP1.Ejercicio8.Queue;
import TP2.Ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> bt;

    public ProfundidadDeArbolBinario() {
        bt = new BinaryTree<>();
    }

    public ProfundidadDeArbolBinario(BinaryTree<Integer> bt) {
        this.bt = bt;
    }

    public int sumaElementosProfundidad(int p) {
        if (bt == null || bt.isEmpty()) return 0;


        BinaryTree<Integer> aux;
        int result = 0;
        int h = 0;

        Queue<BinaryTree<Integer>> q = new Queue<>();
        q.enqueue(bt);
        q.enqueue(null);

        while (!q.isEmpty() && h <= p) {
            aux = q.dequeue();
            if (aux != null) {
                if (h == p) result += aux.getData();
                else {
                    if (aux.hasLeftChild()) q.enqueue(aux.getLeftChild());
                    if (aux.hasRightChild()) q.enqueue(aux.getRightChild());
                }
            } else {
                if (!q.isEmpty() && h != p){
                    h++;
                    q.enqueue(null);
                }
            }
        }
        return result;
    }
}
