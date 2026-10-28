package fabrica.sucursales05;

import java.util.Random;

public class FabricaSucursales05 {
    static final Random RANDOM = new Random(); // Objeto Random para generar precios y cantidades

    // Genera la tabla de precios por sucursal
    static double[][] generarPrecios(final int articulos, final int sucursales) {
        double[][] precios = new double[articulos][sucursales]; // Fila = artículo, columna = sucursal
        for (int i = 0; i < articulos; i++) { // Recorre cada artículo (fila)
            for (int j = 0; j < sucursales; j++) { // Recorre cada sucursal (columna)
                precios[i][j] = Math.round(RANDOM.nextDouble(1, 100) * 100) / 100.0; // Precio entre 1 y 100 con 2 decimales
            }
        }
        return precios; // Devuelve la tabla de precios
    }

    // Genera la tabla de cantidades por sucursal
    static int[][] generarCantidades(final int articulos, final int sucursales) {
        int[][] cantidades = new int[articulos][sucursales]; // Misma estructura que la tabla de precios
        for (int i = 0; i < articulos; i++) { // Recorre cada artículo (fila)
            for (int j = 0; j < sucursales; j++) { // Recorre cada sucursal (columna)
                cantidades[i][j] = RANDOM.nextInt(0, 51); // Cantidad vendida entre 0 y 50
            }
        }
        return cantidades; // Devuelve la tabla de cantidades
    }

    // Muestra una tabla de precios
    static void imprimirPrecios(final String titulo, final double[][] tabla) {
        IO.println(titulo); // Imprime el título de la tabla
        for (double[] fila : tabla) { // Recorre cada fila (artículo)
            for (double valor : fila) { // Recorre cada columna (sucursal)
                IO.print(String.format("%10.2f", valor)); // Imprime el precio alineado
            }
            IO.println(); // Salta de línea al terminar la fila
        }
        IO.println(); // Línea en blanco al final
    }

    // Muestra una tabla de cantidades
    static void imprimirCantidades(final String titulo, final int[][] tabla) {
        IO.println(titulo); // Imprime el título de la tabla
        for (int[] fila : tabla) { // Recorre cada fila (artículo)
            for (int valor : fila) { // Recorre cada columna (sucursal)
                IO.print(String.format("%10d", valor)); // Imprime la cantidad alineada
            }
            IO.println(); // Salta de línea al terminar la fila
        }
        IO.println(); // Línea en blanco al final
    }

    // a) Total de ventas por artículo: suma de precio x cantidad en todas las sucursales (por fila)
    static double[] totalPorArticulo(final double[][] precios, final int[][] cantidades) {
        double[] totales = new double[precios.length]; // Un total por artículo
        for (int i = 0; i < precios.length; i++) { // Recorre cada artículo (fila)
            for (int j = 0; j < precios[0].length; j++) { // Recorre cada sucursal (columna)
                totales[i] += precios[i][j] * cantidades[i][j]; // Suma el valor vendido en esa sucursal
            }
        }
        return totales; // Devuelve los totales de todos los artículos
    }

    // b) Total de ventas por sucursal: suma de precio x cantidad de todos los artículos (por columna)
    static double[] totalPorSucursal(final double[][] precios, final int[][] cantidades) {
        double[] totales = new double[precios[0].length]; // Un total por sucursal
        for (int j = 0; j < precios[0].length; j++) { // Recorre cada sucursal (columna)
            for (int i = 0; i < precios.length; i++) { // Recorre cada artículo (fila)
                totales[j] += precios[i][j] * cantidades[i][j]; // Suma el valor vendido de ese artículo
            }
        }
        return totales; // Devuelve los totales de todas las sucursales
    }

    // Muestra un mensaje, lee una línea de la consola y la convierte a entero
    static int leerEntero(final String mensaje) {
        return Integer.parseInt(IO.readln(mensaje));
    }

    static void main() {
        int n = leerEntero("Número de artículos (N): "); // Lee la cantidad de artículos
        int m = leerEntero("Número de sucursales (M): "); // Lee la cantidad de sucursales

        double[][] precios = generarPrecios(n, m); // Genera la tabla de precios N x M
        int[][] cantidades = generarCantidades(n, m); // Genera la tabla de cantidades vendidas N x M

        IO.println(); // Línea en blanco antes de las tablas
        imprimirPrecios("Tabla de precios (filas = artículos, columnas = sucursales):", precios); // Muestra los precios
        imprimirCantidades("Tabla de cantidades vendidas (filas = artículos, columnas = sucursales):", cantidades); // Muestra las cantidades

        double[] porArticulo = totalPorArticulo(precios, cantidades); // Calcula los totales por artículo
        IO.println("=== TOTAL DE VENTAS POR ARTÍCULO ==="); // Título de la sección
        for (int i = 0; i < n; i++) { // Recorre cada artículo
            IO.println(String.format("Artículo %d: $%.2f", i + 1, porArticulo[i])); // Imprime su total
        }
        IO.println(); // Línea en blanco

        double[] porSucursal = totalPorSucursal(precios, cantidades); // Calcula los totales por sucursal
        IO.println("=== TOTAL DE VENTAS POR SUCURSAL ==="); // Título de la sección
        for (int j = 0; j < m; j++) { // Recorre cada sucursal
            IO.println(String.format("Sucursal %d: $%.2f", j + 1, porSucursal[j])); // Imprime su total
        }
    }
}
