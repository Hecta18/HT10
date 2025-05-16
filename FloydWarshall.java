public class FloydWarshall {
    private final int INF = Integer.MAX_VALUE; // Representa la "infinidad"
    private int[][] dist; // Matriz de distancias
    private int[][] next; // Matriz para reconstruir el camino

// Constructor
public FloydWarshall(int vertices) {
    dist = new int[vertices][vertices];
    next = new int[vertices][vertices];

    // Inicializar la matriz de distancias
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            if (i == j) {
                dist[i][j] = 0; // La distancia de un nodo a sí mismo es 0
            } else {
                dist[i][j] = INF; // Inicializar con infinito
            }
            next[i][j] = -1; // Inicializar la matriz de caminos
        }
    }
}

// Método para agregar una arista al grafo
public void addEdge(int u, int v, int weight) {
    dist[u][v] = weight; // Establecer el peso de la arista
    next[u][v] = v; // Establecer el siguiente nodo en el camino
}

// Método para ejecutar el algoritmo de Floyd-Warshall
public void floydWarshall() {
    int vertices = dist.length;

    for (int k = 0; k < vertices; k++) {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                // Si se encuentra un camino más corto a través de k
                if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]; // Actualizar la distancia
                    next[i][j] = next[i][k]; // Actualizar el siguiente nodo
                }
            }
        }
    }
}

// Método para imprimir la matriz de distancias
public void printSolution() {
    int vertices = dist.length;
    System.out.println("Matriz de distancias más cortas:");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            if (dist[i][j] == INF) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i][j] + " ");
            }
        }
        System.out.println();
    }
}

// Método para reconstruir el camino más corto entre dos nodos
public void printPath(int u, int v) {
    if (next[u][v] == -1) {
        System.out.println("No hay camino de " + u + " a " + v);
        return;
    }
    System.out.print("Camino más corto de " + u + " a " + v + ": " + u);
    while (u != v) {
        u = next[u][v];
        System.out.print(" -> " + u);
    }
    System.out.println();
}

// Método principal para probar la implementación
public static void main(String[] args) {
    FloydWarshall fw = new FloydWarshall(4); // Crear un grafo con 4 nodos

    // Agregar aristas
    fw.addEdge(0, 1, 5);
    fw.addEdge(0, 2, 10);
    fw.addEdge(1, 2, 3);
    fw.addEdge(2, 3, 1);
    fw.addEdge(1, 3, 15);

    // Ejecutar el algoritmo de Floyd-Warshall
    fw.floydWarshall();

    // Imprimir la matriz de distancias
    fw.printSolution();

    // Imprimir el camino más corto entre dos nodos
    fw.printPath(0, 3); // De 0 a 3
    fw.printPath(1, 2); // De 1 a 2
}
