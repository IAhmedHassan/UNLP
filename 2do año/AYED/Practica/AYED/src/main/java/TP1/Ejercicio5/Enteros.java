package TP1.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Enteros {

    static void main() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(17);

        List<Integer> result = returnMethod(arr);
        System.out.println("returnMethod: "+ result);
        Resultado r = new Resultado();
        parameterMethod(arr, r);
        System.out.println("parameterMethod: "+ "max: " + r.getMax() +  "  min: " + r.getMin() + "  prom: " + r.getProm());

    }

    private static void parameterMethod(List<Integer> arr, Resultado res) {
        List<Integer> r = returnMethod(arr);
        res.setMax(r.get(0));
        res.setMin(r.get(1));
        res.setProm(r.get(2));
    }

    public static List<Integer> returnMethod(List<Integer> n) {
        Integer max = Integer.MAX_VALUE, min = Integer.MIN_VALUE, prom = 0;
        for (Integer i : n) {
            if (i > max) max = i;
            if (i < min) min = i;
            prom = prom + i;
        }
        List<Integer> r = new ArrayList<>();
        r.add(max);
        r.add(min);
        r.add((prom / n.size()));

        return r;
    }

    private static class Resultado {
        private Integer max;
        private Integer min;
        private Integer prom;

        public Resultado() {};

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public Integer getProm() {
            return prom;
        }

        public void setProm(Integer prom) {
            this.prom = prom;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }

}
