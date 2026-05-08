package TP1.Ejercicio1;

public class ej1 {
    static void main (String[] args) {
        forMethod(1,10);
        whileMethod(11,20);
        recursiveMethod(21,30);
    }

    public static void forMethod(int inicio, int fin) {
        for (int i = inicio ; i <= fin ; i++) {
            System.out.println(i);
        }
    }

    public static void whileMethod(int inicio, int fin) {
        int i = inicio;
        while (i <= fin) {
            System.out.println(i);
            i++;
        }

    }

    public static void recursiveMethod(int inicio, int fin) {
        System.out.println(inicio);
        if (inicio != fin) {
            recursiveMethod(inicio + 1, fin);
        }

    }
}
