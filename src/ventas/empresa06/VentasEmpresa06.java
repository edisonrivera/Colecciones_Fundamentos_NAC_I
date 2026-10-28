package ventas.empresa06;

import java.util.Random;

public class VentasEmpresa06 {
    static final Random RANDOM = new Random(); // Objeto Random para generar las ventas

    // Genera la matriz de ventas por vendedor
    static double[][] generarVentas(int vendedores, int anios) {
        double[][] ventas = new double[vendedores][anios];
        for (int i = 0; i < vendedores; i++) { // Recorre cada vendedor (fila)
            for (int j = 0; j < anios; j++) { // Recorre cada año (columna)
                ventas[i][j] = Math.round(RANDOM.nextDouble(1000, 50000) * 100) / 100.0; // Venta entre 1000 y 50000 con 2 decimales
            }
        }
        return ventas; // Devuelve la matriz de ventas
    }

    // Muestra la matriz de ventas
    static void imprimirVentas(double[][] ventas) {
        IO.print(String.format("%-12s", "Vendedor")); // Encabezado de la columna de vendedores
        for (int j = 0; j < ventas[0].length; j++) { // Recorre los años para el encabezado
            IO.print(String.format("%12s", "Año " + (j + 1))); // Imprime los años
        }
        IO.println(); // Salta de línea después del encabezado
        for (int i = 0; i < ventas.length; i++) { // Recorre cada vendedor (fila)
            IO.print(String.format("%-12s", "Vendedor " + (i + 1))); // Imprime el nombre del vendedor
            for (int j = 0; j < ventas[0].length; j++) { // Recorre cada año (columna)
                IO.print(String.format("%12.2f", ventas[i][j])); // Imprime la venta alineada
            }
            IO.println(); // Salta de línea al terminar el vendedor
        }
        IO.println(); // Línea en blanco al final
    }

    // Total de ventas de cada vendedor en los M años (suma por fila)
    static double[] totalPorVendedor(double[][] ventas) {
        double[] totales = new double[ventas.length]; // Un total por vendedor
        for (int i = 0; i < ventas.length; i++) { // Recorre cada vendedor (fila)
            for (int j = 0; j < ventas[0].length; j++) { // Recorre cada año (columna)
                totales[i] += ventas[i][j]; // Acumula la venta del año
            }
        }
        return totales; // Devuelve los totales de todos los vendedores
    }

    // Total de ventas de cada año entre todos los vendedores
    static double[] totalPorAnio(double[][] ventas) {
        double[] totales = new double[ventas[0].length]; // Un total por año
        for (int j = 0; j < ventas[0].length; j++) { // Recorre cada año (columna)
            for (int i = 0; i < ventas.length; i++) { // Recorre cada vendedor (fila)
                totales[j] += ventas[i][j]; // Acumula la venta del vendedor
            }
        }
        return totales; // Devuelve los totales de todos los años
    }

    // Total de ventas de la empresa
    static double totalEmpresa(double[][] ventas) {
        double total = 0; // Acumulador del total general
        for (int i = 0; i < ventas.length; i++) { // Recorre cada vendedor (fila)
            for (int j = 0; j < ventas[0].length; j++) { // Recorre cada año (columna)
                total += ventas[i][j]; // Suma cada venta al total
            }
        }
        return total; // Devuelve el total de la empresa
    }

    // Muestra un mensaje, lee una línea de la consola y la convierte a entero
    static int leerEntero(String mensaje) {
        return Integer.parseInt(IO.readln(mensaje));
    }

    static void main() {
        int n = leerEntero("Número de vendedores (N): "); // Lee la cantidad de vendedores
        int m = leerEntero("Número de años (M): "); // Lee la cantidad de años de operación

        double[][] ventas = generarVentas(n, m); // Genera la matriz de ventas N x M

        IO.println(); // Línea en blanco antes de la matriz
        IO.println("=== MATRIZ DE VENTAS ==="); // Título de la matriz
        imprimirVentas(ventas); // Muestra la matriz de ventas

        // Total de ventas por vendedor
        double[] porVendedor = totalPorVendedor(ventas); // Calcula los totales por vendedor
        IO.println("=== TOTAL DE VENTAS POR VENDEDOR ==="); // Título de la sección
        for (int i = 0; i < n; i++) { // Recorre cada vendedor
            IO.println(String.format("Vendedor %d: $%.2f", i + 1, porVendedor[i])); // Imprime su total
        }
        IO.println(); // Línea en blanco

        // Total de ventas por año
        double[] porAnio = totalPorAnio(ventas); // Calcula los totales por año
        IO.println("=== TOTAL DE VENTAS POR AÑO ==="); // Título de la sección
        for (int j = 0; j < m; j++) { // Recorre cada año
            IO.println(String.format("Año %d: $%.2f", j + 1, porAnio[j])); // Imprime su total
        }
        IO.println(); // Línea en blanco

        // Total de ventas de la empresa
        IO.println("=== TOTAL DE VENTAS DE LA EMPRESA ==="); // Título de la sección
        IO.println(String.format("$%.2f", totalEmpresa(ventas))); // Imprime el total general
    }
}
