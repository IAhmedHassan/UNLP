package TP2.Ejercicio6;

/*
Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros.
*/

import TP2.Ejercicio1.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> bt;

    public BinaryTree<Integer> suma() {
        if (bt == null) return null;
        if (bt.isEmpty()) return null;

        BinaryTree<Integer> auxBt = new BinaryTree<>();
        sumaRecursiva(bt, auxBt);
        return auxBt;
    }

    private int sumaRecursiva(BinaryTree<Integer> bt, BinaryTree<Integer> auxBt) {
        int sumaDerecho = 0, sumaIzquierdo = 0;

        if (bt.hasLeftChild()) {
            auxBt.addLeftChild(new BinaryTree<Integer>());
            sumaIzquierdo = sumaRecursiva(bt.getLeftChild(),auxBt.getLeftChild());
        }
        if (bt.hasRightChild()){
            auxBt.addRightChild(new BinaryTree<>());
            sumaDerecho = sumaRecursiva(bt.getRightChild(),auxBt.getRightChild());
        }
        auxBt.setData(sumaIzquierdo + sumaDerecho);
        return bt.getData() + sumaIzquierdo + sumaDerecho;
    }
}
