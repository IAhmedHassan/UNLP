package TP2.Ejercicio8;

import TP2.Ejercicio1.BinaryTree;

/*
 * Ejercicio 8
 * Escribir en una clase ParcialArboles el método público con la siguiente firma:
 * public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
 *
 * El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
 * Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide
 * con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su
 * estructura. Por ejemplo, en la siguiente imagen: arbol1 ES prefijo de arbol2.
 */
public class ParcialArboles {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1 == null 
         || arbol2 == null 
         || arbol1.isEmpty() 
         || arbol2.isEmpty()) 
            return false;

        return esIgual1(arbol1, arbol2); 

    }

    private boolean esIgual1(BinaryTree<Integer> bt1, BinaryTree<Integer> bt2) {
        
        if (bt1.isLeaf()) return bt1.getData() == bt2.getData();

        if (bt1.getData() == bt2.getData()) {
            boolean leftTree = true, rightTree = true;
            
            if (bt1.hasLeftChild()) 
                leftTree = bt2.hasLeftChild() && esIgual1(bt1.getLeftChild(), bt2.getLeftChild());
            
            if (leftTree && bt1.hasRightChild())
                rightTree = bt2.hasRightChild() && esIgual1(bt1.getRightChild(), bt2.getRightChild());

            return leftTree && rightTree;
    
        } else return false;
    }

    private boolean esIgual2(BinaryTree<Integer> bt1, BinaryTree<Integer> bt2) {

        if (bt1 == null) return true;
        if (bt2 == null) return false;
        
        if (bt1.getData() != bt2.getData()) return false;

        return esIgual2(bt1.getLeftChild(), bt2.getLeftChild())
        && esIgual2(bt1.getRightChild(), bt2.getRightChild());
    }
}
