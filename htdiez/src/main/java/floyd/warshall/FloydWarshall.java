package floyd.warshall;

public class FloydWarshall extends Grafo {
    // Constructor
    public FloydWarshall(int vertices) {
        super(vertices);
    }

    // Implementación del método para agregar una arista
    @Override
    public void addEdge(int u, int v, int weight) {
        dist[u][v] = weight; // Establecer el peso de la arista
        next[u][v] = v; // Establecer el siguiente nodo en el camino
    }

    // Método para ejecutar el algoritmo de Floyd-Warshall
    public void floydWarshall() {
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

    // Método para imprimir el camino más corto entre dos nodos
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
}
