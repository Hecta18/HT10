package floyd.warshall;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloydTest {
    private static FloydWarshall fw;

    @BeforeAll
    public static void setUp() {
        // Inicializar un grafo con 4 vértices
        fw = new FloydWarshall(4);
        // Agregar aristas
        fw.addEdge(0, 1, 5);
        fw.addEdge(0, 2, 10);
        fw.addEdge(1, 2, 3);
        fw.addEdge(2, 3, 1);
        fw.addEdge(1, 3, 15);
    }

    @Test
    public void testAddEdge() {
        // Verificar que la arista se haya agregado correctamente
        assertEquals(5, fw.dist[0][1]);
        assertEquals(10, fw.dist[0][2]);
        assertEquals(3, fw.dist[1][2]);
        assertEquals(1, fw.dist[2][3]);
        assertEquals(15, fw.dist[1][3]);
    }

    @Test
    public void testFloydWarshall() {
        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall();

        // Verificar las distancias más cortas
        assertEquals(5, fw.dist[0][1]); // 0 -> 1
        assertEquals(8, fw.dist[0][2]); // 0 -> 1 -> 2
        assertEquals(9, fw.dist[0][3]); // 0 -> 1 -> 2 -> 3
        assertEquals(3, fw.dist[1][2]); // 1 -> 2
        assertEquals(15, fw.dist[1][3]); // 1 -> 3
        assertEquals(4, fw.dist[2][3]); // 2 -> 3
    }

    @Test
    public void testPrintMatrix() {
        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall();

        // Verificar la representación de la matriz de distancias
        String expectedMatrix = "0 5 8 9 \n" +
                                 "INF 0 3 15 \n" +
                                 "INF INF 0 1 \n" +
                                 "INF INF INF 0 \n";
        assertEquals(expectedMatrix, fw.printMatrix());
    }

    @Test
    public void testPrintPath() {
        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall();

        // Verificar el camino más corto de 0 a 3
        // Se espera que el camino sea 0 -> 1 -> 2 -> 3
        String expectedPath = "Camino más corto de 0 a 3: 0 -> 1 -> 2 -> 3\n";
        // Redirigir la salida estándar para capturar la impresión
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        fw.printPath(0, 3);

        // Verificar la salida
        assertEquals(expectedPath, outContent.toString());

        // Restaurar la salida estándar
        System.setOut(System.out);
    }

    @Test
    public void testNoPath() {
        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall();

        // Verificar el camino entre nodos que no tienen conexión
        // Se espera que no haya camino de 3 a 0
        String expectedOutput = "No hay camino de 3 a 0\n";
        // Redirigir la salida estándar para capturar la impresión
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        fw.printPath(3, 0);

        // Verificar la salida
        assertEquals(expectedOutput, outContent.toString());

        // Restaurar la salida estándar
        System.setOut(System.out);
    }
}
