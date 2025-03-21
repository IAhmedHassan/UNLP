/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;
import PaqueteLectura.Lector;

/**
 *
 * @author pelo
 */
public class Ej05Campeonato {
    
    public static void main(String[] args) {
        int maxPartidos = 20, totalPartidos = 0, golesVisitante, golesLocal;
        String visitante, local;
        Partido [] campeonato = new Partido [maxPartidos];
        
        System.out.println("------COPA PELO 2024-------");
        
        System.out.print("Visitante: ");
        visitante = Lector.leerString();
        
            
        while (totalPartidos < maxPartidos && !(visitante.equals("ZZZ"))) {
            System.out.print("Goles Visitante: ");
            golesVisitante = Lector.leerInt();
            
            System.out.print("Local: ");
            local = Lector.leerString();
                     
            System.out.print("Goles Local: ");
            golesLocal = Lector.leerInt();
            
            campeonato[totalPartidos] = new Partido(local,visitante,golesLocal,golesVisitante);
            
            System.out.print("\n\nVisitante: ");
            visitante = Lector.leerString();
            
            totalPartidos++;
        }
        
        System.out.println("Y ASÍ QUEDARON LOS RESULTADOS: \n\n");
        
        int PartidosGanadosRiver = 0, GolesBocaLocal = 0;
        
        for (int i = 0 ; i < totalPartidos ;  i++) {
            System.out.println(
                    campeonato[i].getLocal() + " " +
                    campeonato[i].getGolesLocal() + " VS " +
                    campeonato[i].getVisitante() + " " +
                    campeonato[i].getGolesVisitante()
            );
            
            if (campeonato[i].getGanador().equals("River"))
                PartidosGanadosRiver++;
            
            if (campeonato[i].getLocal().equals("Boca"))
                GolesBocaLocal += campeonato[i].getGolesLocal();
                    
            
        }
        
        System.out.println("Gran temporada para River! ganó un total de " + PartidosGanadosRiver + " partidos.");
        System.out.println("Gran desempeño de Boca! realizó " + GolesBocaLocal + " goles de local.");
        
    }
}
