package matriz.operaciones04;

import java.util.Random;

public class MatrizOperaciones04 {
    static final Random RANDOM = new Random(); // Objeto Random para generar números aleatorios

    // Crea una matriz de filas x columnas con enteros aleatorios entre -100 y 100
    static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas]; // Declara la matriz con el tamaño indicado
        for (int i = 0; i < filas; i++) { // Recorre cada fila
            for (int j = 0; j < columnas; j++) { // Recorre cada columna de la fila actual
                matriz[i][j] = RANDOM.nextInt(-100, 101); // Asigna un entero aleatorio entre -100 y 100
            }
        }
        return matriz; // Devuelve la matriz generada
    }

    // Muestra una matriz en consola con un título
    static void imprimirMatriz(String titulo, int[][] matriz) {
        IO.println(titulo); // Imprime el título de la matriz
        for (int[] fila : matriz) { // Recorre cada fila de la matriz
            for (int valor : fila) { // Recorre cada elemento de la fila
                IO.print(String.format("%4d", valor)); // Imprime el elemento alineado a 4 caracteres
            }
            IO.println(); // Salta de línea al terminar la fila
        }
        IO.println(); // Deja una línea en blanco al final
    }

    // Suma elemento a elemento (ambas matrices deben ser del mismo tamaño)
    static int[][] sumar(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length]; // Matriz resultado con el mismo tamaño
        for (int i = 0; i < a.length; i++) { // Recorre las filas
            for (int j = 0; j < a[0].length; j++) { // Recorre las columnas
                r[i][j] = a[i][j] + b[i][j]; // Suma los elementos en la misma posición
            }
        }
        return r; // Devuelve la matriz suma
    }

    // Resta elemento a elemento (ambas matrices deben ser del mismo tamaño)
    static int[][] restar(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length]; // Matriz resultado con el mismo tamaño
        for (int i = 0; i < a.length; i++) { // Recorre las filas
            for (int j = 0; j < a[0].length; j++) { // Recorre las columnas
                r[i][j] = a[i][j] - b[i][j]; // Resta los elementos en la misma posición
            }
        }
        return r; // Devuelve la matriz diferencia
    }

    // Multiplica A (MxN) por B (NxP); el resultado es de tamaño M x P
    static int[][] multiplicar(int[][] a, int[][] b) {
        int[][] r = new int[a.length][b[0].length]; // Matriz resultado de tamaño M x P
        for (int i = 0; i < a.length; i++) { // Recorre las filas de A
            for (int j = 0; j < b[0].length; j++) { // Recorre las columnas de B
                for (int k = 0; k < b.length; k++) { // Recorre los elementos que se multiplican
                    r[i][j] += a[i][k] * b[k][j]; // Acumula el producto de la fila de A por la columna de B
                }
            }
        }
        return r; // Devuelve la matriz producto
    }

    // Intercambia filas por columnas: el elemento (i,j) pasa a la posición (j,i)
    static int[][] trasponer(int[][] a) {
        int[][] r = new int[a[0].length][a.length]; // Matriz resultado con filas y columnas invertidas
        for (int i = 0; i < a.length; i++) { // Recorre las filas de la original
            for (int j = 0; j < a[0].length; j++) { // Recorre las columnas de la original
                r[j][i] = a[i][j]; // Coloca el elemento (i,j) en la posición (j,i)
            }
        }
        return r; // Devuelve la matriz transpuesta
    }

    // Muestra un mensaje, lee una línea de la consola y la convierte a entero
    static int leerEntero(String mensaje) {
        return Integer.parseInt(IO.readln(mensaje));
    }

    static void main() {
        // Se piden las dimensiones una sola vez y se generan las dos matrices con ese tamaño
        int m = leerEntero("Número de filas (M): "); // Lee la cantidad de filas
        int n = leerEntero("Número de columnas (N): "); // Lee la cantidad de columnas
        int[][] a = generarMatriz(m, n); // Genera la matriz A de tamaño M x N
        int[][] b = generarMatriz(m, n); // Genera la matriz B de tamaño M x N

        IO.println(); // Línea en blanco antes de mostrar las matrices
        imprimirMatriz("Matriz A (" + m + "x" + n + "):", a); // Muestra la matriz A
        imprimirMatriz("Matriz B (" + m + "x" + n + "):", b); // Muestra la matriz B

        // El menú se repite para poder hacer cuantas operaciones se quiera hasta elegir salir
        int opcion;
        do {
            IO.println("=== OPERACIONES CON MATRICES ===");
            IO.println("1. Sumar");
            IO.println("2. Restar");
            IO.println("3. Multiplicar");
            IO.println("4. Trasponer");
            IO.println("0. Salir");
            opcion = leerEntero("Seleccione una opción: "); // Lee la opción elegida

            switch (opcion) {
                case 1 -> imprimirMatriz("A + B =", sumar(a, b)); // Calcula y muestra la suma
                case 2 -> imprimirMatriz("A - B =", restar(a, b)); // Calcula y muestra la resta
                case 3 -> {
                    // Como A y B son M x N, el producto solo es posible si N = M (matrices cuadradas)
                    if (n == m) {
                        imprimirMatriz("A x B =", multiplicar(a, b)); // Calcula y muestra el producto
                    } else {
                        IO.println("No se puede multiplicar: las columnas de A deben ser iguales a las filas de B (M = N).\n");
                    }
                }
                case 4 -> {
                    imprimirMatriz("Transpuesta de A =", trasponer(a)); // Calcula y muestra la transpuesta de A
                    imprimirMatriz("Transpuesta de B =", trasponer(b)); // Calcula y muestra la transpuesta de B
                }
                case 0 -> IO.println("Programa finalizado.");
                default -> IO.println("Opción no válida.\n");
            }
        } while (opcion != 0); // Repite mientras el usuario no elija salir
    }
}
