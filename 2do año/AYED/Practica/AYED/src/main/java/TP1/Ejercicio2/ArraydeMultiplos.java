package TP1.Ejercicio2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraydeMultiplos {
    static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> arr = makeArray(s.nextInt());
        comprobar(arr);
    }

   private static void comprobar(List<Integer> arr) {
       for (int i : arr) {
           System.out.println(i);
       }
       System.out.println(arr);
       System.out.println("Tamaño: "+arr.size());
   }

    private static List<Integer> makeArray(int n) {
       List<Integer> arr = new ArrayList<>();

       for (int i = 1 ; i <= n ; i++) {
           arr.add(i * n);
       }
       return arr;
    }
}
