# Bitácora de Aprendizaje - AyED

En este documento se registran los objetivos, problemas conceptuales y aprendizajes clave de cada ejercicio resuelto, con el fin de fortalecer el modelo mental sobre estructuras de datos y algoritmos.

## TP2 - Árboles Binarios

### Ejercicio 6: Transformación
- **Objetivo:** Crear un nuevo árbol donde cada nodo contenga la suma de sus subárboles izquierdo y derecho del árbol original.
- **Problemas Conceptuales:**
    - **Retorno de la recursión:** Se intentó devolver el objeto `BinaryTree` cuando el padre necesitaba un `int` (la suma acumulada) para su cálculo.
    - **Pérdida de información:** Se intentó usar el `data` ya modificado del hijo, olvidando que el padre necesita la suma del subárbol original (incluyendo el valor que el hijo tenía antes de ser transformado).
- **Aprendizajes Clave:**
    - **Pensamiento Post-orden:** En árboles, si el padre depende de los hijos, primero se resuelve la recursión hacia abajo y se procesa la información al "subir".
    - **Dato de estado vs. Dato de retorno:** Un nodo puede guardar un valor (`setData`) pero reportar uno distinto a su padre (`return`).

### Ejercicio 5: Profundidad de Árbol Binario
- **Objetivo:** Sumar los valores de los nodos que se encuentran exactamente a una profundidad `p`.
- **Problemas Conceptuales:**
    - **Referencia estática vs. dinámica:** Uso de la variable de instancia `bt` (raíz) dentro de un bucle que debería ser iterativo sobre `aux` (nodo actual).
    - **Exploración de niveles (Puentes):** Se bloqueó el encolamiento de hijos por una condición mal ubicada, olvidando que para llegar a un nivel profundo hay que recorrer y encolar los niveles anteriores.
    - **Seguridad (Short-circuit):** Importancia de chequear `null` antes de invocar métodos para evitar excepciones.
- **Aprendizajes Clave:**
    - **BFS (Breadth-First Search):** Recorrido por niveles usando una `Queue` y un marcador `null` para separar niveles.
    - **Doble rol del nodo:** Un nodo en un nivel `h < p` actúa como puente (sus hijos importan); en `h == p` actúa como objetivo (su dato importa).
