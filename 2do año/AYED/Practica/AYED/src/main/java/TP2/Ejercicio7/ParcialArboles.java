import Ejercicio1.BinaryTree; 

public class ParcialArboles {
  private BinaryTree<Integer> bt;
  
  public ParcialArboles() {
    bt = new BinaryTree<>();
  }

  public boolean isLeftTree(int num) {
    if (bt == null || bt.isEmpty()) return false;

    busquedaRecursiva(int num);
  }

  private 
}
