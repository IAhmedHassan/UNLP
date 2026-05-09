package TP2.Ejercicio9;

import TP2.Ejercicio1.BinaryTree;

/*
 * Ejercicio 9
 * Escribir en una clase ParcialArboles el método público con la siguiente firma:
 * public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol)
 *
 * El método recibe un árbol binario de enteros y devuelve un nuevo árbol que contenga en cada
 * nodo dos tipos de información:
 * - La suma de los números a lo largo del camino desde la raíz hasta el nodo actual.
 * - La diferencia entre el número almacenado en el nodo original y el número almacenado en el
 *   nodo padre.
 *
 * Nota: En el nodo raíz considere que el valor del nodo padre es 0.
 * Importante: El resultado debe ser un NUEVO árbol.
 */
public class ParcialArboles {

    private class Node {
        public int sumaTotal;
        public int diferencia;

        public Node(int unaSumaTotal, int unaDiferencia) {
            sumaTotal = unaSumaTotal;
            diferencia = unaDiferencia;
        }
    }
    
    public BinaryTree<Node> sumAndDif(BinaryTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;

        return sumAndDifRecursive(arbol, 0,  0);
    }

    private BinaryTree<Node> sumAndDifRecursive(BinaryTree<Integer> bt, int totalSum, int fatherValue) {

        Node node = new Node(totalSum + bt.getData(), bt.getData() - fatherValue);
        BinaryTree<Node> btResult = new BinaryTree<>(node);
        
        if (bt.hasLeftChild())
            btResult.addLeftChild(sumAndDifRecursive(bt.getLeftChild(), node.sumaTotal, bt.getData()));
        if (bt.hasRightChild())
            btResult.addRightChild(sumAndDifRecursive(bt.getRightChild(), node.sumaTotal, bt.getData()));

        return btResult; 
    }

}
