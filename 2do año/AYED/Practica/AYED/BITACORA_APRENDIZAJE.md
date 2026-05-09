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
### Ejercicio 7: Parcial - isLeftTree
- **Objetivo:** Buscar un nodo y comparar la cantidad de "hijos únicos" en sus subárboles izquierdo y derecho.
- **Aprendizajes Clave:**
    - **Combinación de recorridos:** Uso de Pre-orden para la búsqueda del nodo y Post-orden para la acumulación de datos (conteo).
    - **Manejo de Casos Especiales:** Implementación de condiciones de borde específicas (retornar -1 si una rama no existe).
### Ejercicio 8: Parcial - esPrefijo
- **Objetivo:** Determinar si un árbol es el inicio estructural y de contenido de otro.
- **Aprendizajes Clave:**
    - **Comparación Paralela:** Recorrido simultáneo de dos estructuras para validar coincidencia nodo a nodo.
    - **Lógica de Prefijo:** Entender que la condición de éxito depende de que el "árbol patrón" se agote, sin importar el resto del "árbol objetivo".
    - **Cortocircuito (Short-circuit):** Optimización de la recursión mediante el uso de operadores logicos (`&&`) para evitar procesar ramas innecesarias.

### Ejercicio 9: Parcial - sumAndDif
- **Objetivo:** Crear un nuevo árbol con información combinada (suma de camino y diferencia con el padre).
- **Aprendizajes Clave:**
    - **Recursión Constructora:** Creación de una estructura espejo devolviendo el nuevo subárbol en cada llamada recursiva.
    - **Pasaje de Estado Top-Down:** Uso de parámetros para "bajar" información desde la raíz hacia las hojas (sumas acumuladas y valores de ancestros).
    - **Uso de Tipos Genéricos (Wildcards):** Implementación de una clase interna (`Node`) para cumplir con el retorno `BinaryTree<?>` y almacenar múltiples datos por nodo.

## TP3 - Árboles Generales

### Ejercicio 2: Recorridos en Árboles Generales
- **Objetivo:** Adaptar los recorridos clásicos (Pre, In, Post, Niveles) a una estructura con lista de hijos.
- **Aprendizajes Clave:**
    - **In-orden en AG:** Comprensión de la lógica "primer hijo -> raíz -> resto de los hijos" y su implementación con Iteradores.
    - **Robustez en Iteradores:** Manejo de casos de borde (nodos hoja) para evitar `NoSuchElementException` al avanzar manualmente el iterador.
    - **Patrón Acumulador:** Uso de una lista única pasada por parámetro para recolectar resultados de forma eficiente.
    - **Arquitectura (Static vs Instance):** Reflexión sobre cuándo un comportamiento pertenece a una clase de utilidad (estático) vs. al propio objeto (instancia).

### Ejercicio 3: Propiedades Estructurales (Altura, Nivel, Ancho)
- **Objetivo:** Implementar métodos de consulta sobre la estructura del árbol dentro de la clase `GeneralTree`.
- **Aprendizajes Clave:**
    - **Altura (Post-orden):** Cálculo recursivo basado en el máximo de las alturas de los hijos (`Math.max`).
    - **Nivel (Pre-orden con Búsqueda):** Implementación de búsqueda con retorno inmediato (short-circuit) y propagación de nivel hacia las hojas.
    - **Ancho (BFS con Marcadores):** Uso de una `Queue` con elementos `null` como separadores de nivel para contar nodos por horizonte y determinar el máximo.

### Ejercicio 4: Analizador de Empresa (Máximo Promedio)
- **Objetivo:** Calcular el promedio de valores por nivel y encontrar el máximo entre ellos.
- **Aprendizajes Clave:**
    - **BFS para Estadísticas por Nivel:** Uso de acumuladores (suma y contador) que se resetean al encontrar el marcador de nivel (`null`).
    - **Precisión Numérica:** Importancia del casting a `double` para evitar la pérdida de información en divisiones enteras.

### Ejercicio 5: Profundidad de Árbol Binario
- **Objetivo:** Sumar los valores de los nodos que se encuentran exactamente a una profundidad `p`.
- **Problemas Conceptuales:**
    - **Referencia estática vs. dinámica:** Uso de la variable de instancia `bt` (raíz) dentro de un bucle que debería ser iterativo sobre `aux` (nodo actual).
    - **Exploración de niveles (Puentes):** Se bloqueó el encolamiento de hijos por una condición mal ubicada, olvidando que para llegar a un nivel profundo hay que recorrer y encolar los niveles anteriores.
    - **Seguridad (Short-circuit):** Importancia de chequear `null` antes de invocar métodos para evitar excepciones.
- **Aprendizajes Clave:**
    - **BFS (Breadth-First Search):** Recorrido por niveles usando una `Queue` y un marcador `null` para separar niveles.
    - **Doble rol del nodo:** Un nodo en un nivel `h < p` actúa como puente (sus hijos importan); en `h == p` actúa como objetivo (su dato importa).

---

## Ejercitación Teórica: AB y AG

En esta sección se registra el análisis conceptual de la ejercitación teórica (sin código), enfocándose en la reconstrucción de árboles, recorridos y cálculos de nodos.

### Ejercicio 1: Descendientes de "C"
- **Análisis:** 
    1. Identificación de la Raíz: En **Postorden**, el último elemento (`D`) es la raíz del árbol.
    2. Partición del Árbol: En el **Inorden**, todo lo que está a la derecha de `D` (`J H I C`) pertenece al subárbol derecho.
    3. Raíz del Subárbol: En Postorden, el elemento inmediatamente anterior a la raíz global suele ser la raíz del subárbol derecho (`C`).
    4. Estructura de "C": Mirando el Inorden del subárbol (`J H I C`), vemos que `C` está al final, lo que implica que `J`, `H` e `I` están todos en su subárbol izquierdo (son sus descendientes).
- **Conclusión:** (c) 3
- **Aprendizaje:** La combinación de Postorden (identifica raíces de atrás hacia adelante) e Inorden (delimita subárboles izquierdo/derecho) permite reconstruir la jerarquía sin necesidad de dibujar el árbol completo.

### Ejercicio 2: Definiciones de Árboles (Lleno vs. Completo)
- **Definiciones:**
    - **Árbol Lleno:** Todos los niveles están completos. Todos los nodos internos tienen 2 hijos y todas las hojas están en el mismo nivel ($2^{h+1}-1$ nodos).
    - **Árbol Completo:** Lleno hasta el nivel $h-1$, y el nivel $h$ se completa de izquierda a derecha.
- **Análisis:** 
    - Un árbol lleno cumple con la definición de completo (está lleno de izquierda a derecha en su último nivel).
    - Un árbol completo puede tener el último nivel incompleto, por lo que no siempre es lleno.
- **Conclusión:** Todo árbol lleno es completo, pero no viceversa.
- **Aprendizaje:** La distinción técnica entre "Lleno" y "Completo" radica en la obligatoriedad de completar el último nivel.

### Ejercicio 3: Coincidencia de recorridos (Postorden vs. Inorden)
- **Análisis:** 
    1. El último elemento en **Postorden** (Izquierda-Derecha-Raíz) es siempre la **Raíz** del árbol.
    2. El último elemento en **Inorden** (Izquierda-Raíz-Derecha) es el nodo que se encuentra más a la derecha en la estructura.
    3. Si la Raíz es el último elemento visitado en Inorden, significa que no existe un subárbol derecho que la siga.
- **Conclusión:** (b) El subárbol derecho de T es vacío.
- **Aprendizaje:** Las posiciones relativas de la raíz en diferentes recorridos revelan la existencia o ausencia de ramas enteras.

### Ejercicio 4: Recorrido Híbrido (Pre-orden + Post-orden)
- **Análisis:** 
    - El código realiza dos impresiones por cada nodo: una al "entrar" (comportamiento de Pre-orden) y otra al "salir" (comportamiento de Post-orden).
    - Traza paso a paso:
        1. Raíz `C`: imprime `C`, baja a la izquierda (`A`).
        2. Nodo `A`: imprime `A`, baja a la derecha (`B`).
        3. Nodo `B`: imprime `B`, termina hijos, imprime `B`. (Sale de `B`).
        4. Regresa a `A`: imprime `A`. (Sale de `A`).
        5. Regresa a `C`: baja a la derecha (`E`).
        6. Nodo `E`: imprime `E`, baja a la izquierda (`D`).
        7. Nodo `D`: imprime `D`, termina, imprime `D`. (Sale de `D`).
        8. Regresa a `E`: baja a la derecha (`F`).
        9. Nodo `F`: imprime `F`, termina, imprime `F`. (Sale de `F`).
        10. Regresa a `E`: imprime `E`. (Sale de `E`).
        11. Regresa a `C`: imprime `C`. (Fin).
- **Conclusión:** `C A B B A E D D F F E C`
- **Aprendizaje:** Un único recorrido recursivo puede procesar información en diferentes momentos (antes y después de las llamadas a los hijos), permitiendo capturar estados antes de profundizar y después de haber resuelto los subárboles.

### Ejercicio 5: Evaluación de Expresión Postfija (Pila)
- **Expresión:** `6 5 * 7 3 − 4 8 + * +`
- **Análisis (Seguimiento de Pila):** 
    1. Apilar 6, 5 -> Operador `*`: `6 * 5 = 30`. Apilar 30.
    2. Apilar 7, 3 -> Operador `-`: `7 - 3 = 4`. Apilar 4.
    3. Apilar 4, 8 -> Operador `+`: `4 + 8 = 12`. Apilar 12.
    4. Pila actual: `[30, 4, 12]`.
    5. Operador `*`: `4 * 12 = 48`. Apilar 48.
    6. Operador `+`: `30 + 48 = 78`. 
- **Conclusión:** (a) 78
- **Aprendizaje:** En expresiones postfijas, el orden de desapilado es crítico para operaciones no conmutativas (resta/división): el primer elemento desapilado es el operando de la derecha.
