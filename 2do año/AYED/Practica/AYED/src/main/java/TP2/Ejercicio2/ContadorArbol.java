package TP2.Ejercicio2;



import TP2.Ejercicio1.BinaryTree;
import java.util.ArrayList;
import java.util.List;

/*
Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.
 */

public class ContadorArbol {
    private BinaryTree<Integer> bt;

    public ContadorArbol() {
        bt = new BinaryTree<>();
    }

    public List<Integer> numerosParesInOrder() {
        List<Integer> pares = new ArrayList<>();

        if (bt.isEmpty()) return pares;
        else buscarParesInOrder(bt, pares);

        return pares;
    }

    private void buscarParesInOrder(BinaryTree<Integer> bt, List<Integer> pares) {
        if (bt.hasLeftChild()) buscarParesInOrder(bt.getLeftChild(), pares);
        if (bt.getData() % 2 == 0) pares.add(bt.getData());
        if (bt.hasRightChild()) buscarParesInOrder(bt.getRightChild(), pares);
    }

    public List<Integer> numerosParesPostOrder() {
        List<Integer> pares = new ArrayList<>();

        if (bt.isEmpty()) return pares;
        else buscarParesPostOrder(bt, pares);

        return pares;
    }

    private void buscarParesPostOrder(BinaryTree<Integer> bt, List<Integer> pares) {
        if (bt.hasLeftChild()) buscarParesPostOrder(bt.getLeftChild(), pares);
        if (bt.hasRightChild()) buscarParesPostOrder(bt.getRightChild(), pares);
        if (bt.getData() % 2 == 0) pares.add(bt.getData());
    }
}
