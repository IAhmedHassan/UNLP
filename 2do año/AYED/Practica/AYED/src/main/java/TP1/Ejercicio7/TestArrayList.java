package TP1.Ejercicio7;
import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    private List<Integer> list;

    void main(String[] args) {
        list = new ArrayList<Integer>();

        // agregar a la lista
        for (String s : args)
            list.add(Integer.parseInt(s));

        // iterar para imprimir
        for (Integer i : list) System.out.println(i);
    }


}
