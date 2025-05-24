package floyd.warshall;

public abstract class Grafo {
    protected final int INF = Integer.MAX_VALUE; // Representa la "infinidad"
    protected int[][] dist; // Matriz de distancias
    protected int[][] next; // Matriz para reconstruir el camino
    protected int vertices; // Número de vértices en el grafo

    // Constructor
    public Grafo(int vertices) {
        this.vertices = vertices;
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

    // Método abstracto para agregar una arista al grafo
    public abstract void addEdge(int u, int v, int weight);

    // Método para imprimir la matriz de distancias como un String
    public String printMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF) {
                    sb.append("INF ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
