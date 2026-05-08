package TP2.Ejercicio1;

/*

Ejercicio 1
Agregue a la clase BinaryTree los siguientes métodos:
a) contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.
b) espejo(): BinaryTree<T> Devuelve el árbol binario espejo del árbol receptor.
c) entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol
receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)
 */

import TP1.Ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		if (this.isEmpty()) return 0;
		else if (this.isLeaf()) return 1;
		else {
			int count = 0;
			if (this.hasLeftChild()) count = this.getLeftChild().contarHojas();
			if (this.hasRightChild()) count += this.getRightChild().contarHojas();
			return count;
		}
	}
		
		
    	 
    public BinaryTree<T> espejo(){
		if (this.isEmpty()) return new BinaryTree<>();
		else {
			BinaryTree<T> mirror = new BinaryTree<>();
			mirror.setData(this.getData());
			if (this.hasLeftChild())
				mirror.addRightChild(this.getLeftChild().espejo());
			if (this.hasRightChild())
				mirror.addLeftChild(this.getRightChild().espejo());

			return mirror;
		}
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		Queue<BinaryTree<T>> q = new Queue<>();
		int level = 0;
		q.enqueue(this);
		q.enqueue(null);

		while (!q.isEmpty()) {
			BinaryTree<T> bt = q.dequeue();
			if (bt != null) {
				if (level >= n && level <= m) {
					System.out.println(bt.getData().toString());
				}
				if (bt.hasLeftChild()) q.enqueue(bt.getLeftChild());
				if (bt.hasRightChild()) q.enqueue(bt.getRightChild());
			}
			else {
				if (!q.isEmpty()) {
					q.enqueue(null);
					level++;
				}
			}
		}

   }
		
}

