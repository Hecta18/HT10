# HT10
Uso de grafos y algoritmo de Floyd para ruta más corta.
Visita nuestra [wiki](../../wiki) para aprender sobre nuestro proceso de desarrollo y el software.

### Resumen de Instrucciones para la Hoja de Trabajo No. 10
**Objetivo General:** Implementar un programa en Java que utilice el algoritmo de Floyd para encontrar el camino más corto entre pares de vértices en un grafo, y calcular el centro del grafo.

#### Actividades a Realizar:
1. **Implementación de un Grafo en Java:**
   - Crear un grafo dirigido, preferiblemente usando una matriz de adyacencia.
   
2. **Implementación del Algoritmo de Floyd:**
   - Desarrollar el algoritmo para determinar la ruta más corta entre cualquier par de nodos, mostrando el peso de la ruta y los nodos intermedios.

3. **Cálculo del Centro del Grafo:**
   - Utilizar los resultados del algoritmo de Floyd para identificar el centro del grafo.

4. **Interacción con el Usuario:**
   - Leer el grafo desde un archivo `logistica.txt`, que contiene ciudades y tiempos de viaje bajo diferentes condiciones climáticas.
   - Permitir al usuario consultar rutas, modificar el grafo y recalcular rutas y el centro del grafo.

#### Problema a Resolver:
Una empresa de logística necesita optimizar su cadena de suministro utilizando el algoritmo de Floyd, considerando factores como la congestión del tráfico y las condiciones climáticas. Se debe construir un grafo ponderado donde los nodos representan ubicaciones y los bordes representan distancias ajustadas por condiciones climáticas.

#### Requisitos del Archivo `logistica.txt`:
- Formato: `Ciudad1 Ciudad2 tiempoNormal tiempoLluvia tiempoNieve tiempoTormenta`
- Ejemplo:
  ```
  BuenosAires SaoPaulo 10 15 20 50
  BuenosAires Lima 15 20 30 70
  Lima Quito 10 12 15 20
  ```

#### Funcionalidades del Programa:
1. Consultar la ruta más corta entre dos ciudades.
2. Identificar la ciudad que queda en el centro del grafo.
3. Modificar el grafo (interrupciones de tráfico, nuevas conexiones, condiciones climáticas).
4. Finalizar el programa.

#### Tareas Específicas:
- Implementar el grafo y el algoritmo de Floyd en Java.
- Usar JUnit para pruebas unitarias de métodos clave.
- Utilizar un sistema de control de versiones (Git).
- Crear un diagrama UML de clases.
- Incluir todos los elementos en la entrega final.

#### Calificación:
- Total de 100 puntos, distribuidos entre implementación, pruebas, diagrama UML y control de versiones.
- Opción de obtener hasta 30 puntos extra por implementar el programa en Python usando NetworkX.
