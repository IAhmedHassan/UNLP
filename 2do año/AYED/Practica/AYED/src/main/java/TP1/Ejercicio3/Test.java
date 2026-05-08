package TP1.Ejercicio3;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static void main() {
        List<Profesor> profes = new ArrayList<>();
        List<Estudiante> estudiantes = new ArrayList<>();

        profes.add(new Profesor("pepe", "el pepauri", "pepelpepauri@gmail.com", "Intro a los pepes", "poponautica"));
        profes.add(new Profesor("papo", "el pepauri", "papolpepauri@gmail.com", "Intro a los papos", "paponautica"));
        profes.add(new Profesor("popo", "el pepauri", "popolpepauri@gmail.com", "Intro a los popos", "poponautica"));
        estudiantes.add(new Estudiante("juan", "juanon", 2, "juani@juan", "av los juanes"));
        estudiantes.add(new Estudiante("robert", "roberton", 1, "roberti@robert", "av los robertes"));
        estudiantes.add(new Estudiante("pete", "peteon", 3, "petei@pete", "av los petees"));

        for (Profesor p : profes) {
            System.out.println(p.tusDatos());
        }

        for (Estudiante e : estudiantes) {
            System.out.println(e.tusDatos());
        }
    }
}
