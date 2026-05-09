package Structures;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this.isLeaf()) return 0;
        int max = 0;
        for (GeneralTree<T> child : this.getChildren()) {
            int h = child.altura() + 1;
            if (h > max) max = h;
        }
        return max;
	}
	
	public int nivel(T dato){
		return calcularNivelRecursivo(dato, 0);
	  }

    private int calcularNivelRecursivo(T dato, int level) {

        if (this.getData() != null && this.getData().equals(dato)) return level;
        
        for (GeneralTree<T> child : this.getChildren()){
            int levelEncontrado = child.calcularNivelRecursivo(dato, level + 1);

            if (levelEncontrado != -1) return levelEncontrado;
        } 

        return -1;


    }

	public int ancho(){
        // if (this == null && this.isEmpty()) return 0;
        int maxAncho = 0;
        Queue<GeneralTree<T>> q = new Queue<>();
        q.enqueue(this);
        q.enqueue(null);
        int anchoActual = 0;
        while (!q.isEmpty()) {
            GeneralTree<T> gt = q.dequeue();
            if (gt != null){
                anchoActual++;
                for(GeneralTree<T> child : gt.getChildren()) {
                    q.enqueue(child);
                }
            } else {

                if (!q.isEmpty()) {
                    maxAncho = Math.max(maxAncho, anchoActual);
                    q.enqueue(null);
                    anchoActual = 0;
                }
            } 
        }
        return maxAncho;
	}

    public boolean esAncestro(T a, T b) {
        if (a == null || b == null) return false;
        GeneralTree<T> ancestor = this.encontrarRecursivo(a);
        if (ancestor != null) {
            GeneralTree<T> ancestree = null;
            for (GeneralTree<T> child : ancestor.getChildren()) {
                ancestree = child.encontrarRecursivo(b);
                if (ancestree != null) return true;
            }
        }
        return false;
    }

    private GeneralTree<T> encontrarRecursivo(T a) {
        if (this.isEmpty()) return null;
        
        if (this.getData().equals(a)) return this;
        GeneralTree<T> result = null;
        for(GeneralTree<T> child : this.getChildren()) {
            result = child.encontrarRecursivo(a);

            if (result != null) return result;
        }
        return result;
    }


}