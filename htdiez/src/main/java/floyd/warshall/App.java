package floyd.warshall;

import java.util.Scanner;

public final class App {
    private App() {
        // Constructor privado para evitar instanciación
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicitar el número de vértices
        System.out.print("Ingrese el número de vértices en el grafo: ");
        int vertices = scanner.nextInt();

        // Crear una instancia de FloydWarshall
        FloydWarshall fw = new FloydWarshall(vertices);

        // Solicitar la cantidad de aristas
        System.out.print("Ingrese el número de aristas: ");
        int edges = scanner.nextInt();

        // Solicitar los datos de las aristas
        for (int i = 0; i < edges; i++) {
            System.out.print("Ingrese el nodo de origen (u): ");
            int u = scanner.nextInt();
            System.out.print("Ingrese el nodo de destino (v): ");
            int v = scanner.nextInt();
            System.out.print("Ingrese el peso de la arista: ");
            int weight = scanner.nextInt();

            // Agregar la arista al grafo
            fw.addEdge(u, v, weight);
        }

        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall();

        // Imprimir la matriz de distancias
        System.out.println("Matriz de distancias más cortas:");
        System.out.println(fw.printMatrix());

        // Solicitar al usuario que ingrese pares de nodos para imprimir el camino más corto
        while (true) {
            System.out.print("Ingrese el nodo de origen para el camino más corto (o -1 para salir): ");
            int start = scanner.nextInt();
            if (start == -1) {
                break; // Salir del bucle si el usuario ingresa -1
            }
            System.out.print("Ingrese el nodo de destino: ");
            int end = scanner.nextInt();

            // Imprimir el camino más corto entre los nodos
            fw.printPath(start, end);
        }

        // Cerrar el escáner
        scanner.close();
    }
}
