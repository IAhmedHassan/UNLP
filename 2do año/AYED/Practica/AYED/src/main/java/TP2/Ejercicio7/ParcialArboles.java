package TP2.Ejercicio7;

import TP2.Ejercicio1.BinaryTree;

/*
 * Ejercicio 7
 * Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
 * BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
 * public boolean isLeftTree (int num)
 *
 * El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
 * cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
 * contrario. Consideraciones:
 * - Si “num” no se encuentra en el árbol, devuelve false.
 * - Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay
 *   -1 árboles con único hijo.
 */
public class ParcialArboles {
  private BinaryTree<Integer> bt;
  
  public ParcialArboles() {
    bt = new BinaryTree<>();
  }

  public boolean isLeftTree(int num) {
    if (bt == null || bt.isEmpty()) return false;

    BinaryTree<Integer> numSubBt = findTreeWithNumber(bt, num); 

    if (numSubBt == null) {
      return false;

    } else {

      int leftTreeResult = (numSubBt.hasLeftChild()) ? countOnlyChildsRecursive(numSubBt.getLeftChild()) : -1;  
      int rightTreeResult = (numSubBt.hasRightChild()) ? countOnlyChildsRecursive(numSubBt.getRightChild()) : -1;  
      
      return leftTreeResult > rightTreeResult;
    }

  }

  private BinaryTree<Integer> findTreeWithNumber(BinaryTree<Integer> bt, int num) {
    if (bt.getData() == num) {
      return bt;
    }

    BinaryTree<Integer> auxBT = null;

    if (bt.hasLeftChild()){
      auxBT = findTreeWithNumber(bt.getLeftChild(), num);
    }

    if (auxBT == null && bt.hasRightChild()) {
      auxBT = findTreeWithNumber(bt.getRightChild(), num);
    }

    return auxBT;
  }

  private int countOnlyChildsRecursive(BinaryTree<Integer> bt) {
    
    if (bt.isLeaf()) return 0;
    
    int leftTreeResult = (bt.hasLeftChild()) ? countOnlyChildsRecursive(bt.getLeftChild()) : 0;
    int rightTreeResult = (bt.hasRightChild()) ? countOnlyChildsRecursive(bt.getRightChild()) : 0;
    
    return leftTreeResult + rightTreeResult + hasOnlyOneChild(bt); 
  }

  private int hasOnlyOneChild(BinaryTree<Integer> bt) {
    return ((bt.hasLeftChild() && !bt.hasRightChild()) || (!bt.hasLeftChild() && bt.hasRightChild())) ? 1 : 0;
  }
}
