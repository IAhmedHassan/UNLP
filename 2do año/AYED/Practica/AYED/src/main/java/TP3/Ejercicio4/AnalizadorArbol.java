package TP3.Ejercicio4;
import Structures.GeneralTree;
import Structures.Queue;

/*
 * Ejercicio 4
 * El esquema de comunicación de una empresa está organizado en una estructura jerárquica, en donde
 * cada nodo envía el mensaje a sus descendientes. Cada nodo posee el tiempo que tarda en transmitir el
 * mensaje.
 * 
 * Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
 * Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. 
 * Por lo tanto, debe devolver 16.
 * 
 * a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
 * Rta: Se utiliza un recorrido por niveles (BFS) ya que el problema requiere procesar y agrupar 
 * la información de los nodos nivel por nivel para calcular sus promedios de forma independiente.
 * 
 * b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
 * public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol)
 */
public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        if (arbol == null || arbol.isEmpty()) return 0;

        double maxProm = 0;

        Queue<GeneralTree<AreaEmpresa>> q = new Queue<>();
        q.enqueue(arbol);
        q.enqueue(null);
        int cantNivel = 0, totalNivel = 0;

        while (!q.isEmpty()) {
            GeneralTree<AreaEmpresa> areaEmpresaBT = q.dequeue();
            
            if (areaEmpresaBT != null) {
                cantNivel++; totalNivel += areaEmpresaBT.getData().getRetardo();

                for (GeneralTree<AreaEmpresa> child : areaEmpresaBT.getChildren()) {
                    q.enqueue(child);
                }

            } else {
                maxProm = Math.max(maxProm, (double) totalNivel / cantNivel);
                cantNivel = 0; totalNivel = 0;

                if(!q.isEmpty()) {
                    q.enqueue(null);
                }
            }
        }
        return maxProm;
    }
}
