package TP2.Ejercicio3;
// a. Se resuelve mejor con una búsqueda en profundidad

import TP2.Ejercicio1.BinaryTree;

/*
Una red binaria es una red que posee una topología de árbol binario lleno.
Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
(Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.
a)
Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.
b)
Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
método retardoReenvio():int
 */

// hay que conseguir el 

public class RedBinariaLlena {
    private BinaryTree<Integer> bt;

    public RedBinariaLlena(BinaryTree<Integer> retardos) {
        this.bt = retardos;
    }

    public int retardoReenvio() {
        if (bt == null || bt.isEmpty()) return 0;
        return calcularRetardoRecursivo(bt);
    }

    private int calcularRetardoRecursivo(BinaryTree<Integer> bt) {
        if (bt.isLeaf()) {
            return bt.getData();
        } else {
            int leftChild = (bt.hasLeftChild()) ? calcularRetardoRecursivo(bt.getLeftChild()) : 0;
            int rightChild = (bt.hasRightChild()) ? calcularRetardoRecursivo(bt.getRightChild()) : 0;
            // return (rightChild >= leftChild) ? rightChild + bt.getData() : leftChild + bt.getData();
            return Math.max(leftChild, rightChild) + bt.getData();
        }
    }
}
