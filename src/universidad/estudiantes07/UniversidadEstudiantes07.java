package universidad.estudiantes07;

import java.util.Random;

public class UniversidadEstudiantes07 {
    static final int MATERIAS = 8; // Cantidad de materias que toma cada estudiante
    static final Random RANDOM = new Random(); // Objeto Random para generar las calificaciones

    // Genera la calificación final de cada estudiante en cada materia (entre 0.0 y 10.0)
    static double[][] generarNotas(int estudiantes) {
        double[][] notas = new double[estudiantes][MATERIAS]; // Fila = estudiante, columna = materia
        for (int i = 0; i < estudiantes; i++) { // Recorre cada estudiante (fila)
            for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia (columna)
                notas[i][j] = Math.round(RANDOM.nextDouble(0, 10.01) * 10) / 10.0; // Nota con un decimal
            }
        }
        return notas; // Devuelve la tabla de calificaciones
    }

    // Muestra la tabla con el código del estudiante y sus notas en las 8 materias
    static void imprimirNotas(int[] codigos, double[][] notas) {
        IO.print(String.format("%-10s", "Código")); // Encabezado de la columna de códigos
        for (int j = 0; j < MATERIAS; j++) { // Recorre las materias para el encabezado
            IO.print(String.format("%7s", "Mat" + (j + 1))); // Imprime Mat1, Mat2, ..., Mat8
        }
        IO.println(); // Salta de línea después del encabezado
        for (int i = 0; i < notas.length; i++) { // Recorre cada estudiante (fila)
            IO.print(String.format("%-10d", codigos[i])); // Imprime el código del estudiante
            for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia (columna)
                IO.print(String.format("%7.1f", notas[i][j])); // Imprime la nota del estudiante en esa materia
            }
            IO.println(); // Salta de línea al terminar el estudiante
        }
        IO.println(); // Línea en blanco al final de la tabla
    }

    // a) Promedio de las calificaciones de cada estudiante (promedio por fila)
    static double[] promedioPorEstudiante(double[][] notas) {
        double[] promedios = new double[notas.length]; // Un promedio por estudiante
        for (int i = 0; i < notas.length; i++) { // Recorre cada estudiante (fila)
            double suma = 0; // Acumulador de las notas del estudiante
            for (int j = 0; j < MATERIAS; j++) { // Recorre sus 8 materias (columnas)
                suma += notas[i][j]; // Suma la nota de la materia
            }
            promedios[i] = suma / MATERIAS; // Calcula el promedio del estudiante
        }
        return promedios; // Devuelve los promedios de todos los estudiantes
    }

    // b) Promedio de la calificación de cada materia (promedio por columna)
    static double[] promedioPorMateria(double[][] notas) {
        double[] promedios = new double[MATERIAS]; // Un promedio por materia
        for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia (columna)
            double suma = 0; // Acumulador de las notas de la materia
            for (int i = 0; i < notas.length; i++) { // Recorre todos los estudiantes (filas)
                suma += notas[i][j]; // Suma la nota del estudiante en esa materia
            }
            promedios[j] = suma / notas.length; // Calcula el promedio de la materia
        }
        return promedios; // Devuelve los promedios de todas las materias
    }

    // c) Posición del estudiante con mayor promedio
    static int mejorEstudiante(double[] promedios) {
        int mejor = 0; // Se asume que el primer estudiante es el mejor
        for (int i = 1; i < promedios.length; i++) { // Recorre el resto de estudiantes
            if (promedios[i] > promedios[mejor]) { // Si tiene un promedio mayor al mejor actual
                mejor = i; // Actualiza la posición del mejor estudiante
            }
        }
        return mejor; // Devuelve la posición del estudiante con mayor promedio
    }

    // d) y e) Cuenta aprobados (nota >= 7 y <= 10) o reprobados (nota < 7) por materia
    static int[] contarPorMateria(double[][] notas, boolean aprobados) {
        int[] conteo = new int[MATERIAS]; // Un contador por materia
        for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia (columna)
            for (int i = 0; i < notas.length; i++) { // Recorre todos los estudiantes (filas)
                boolean aprobo = notas[i][j] >= 7 && notas[i][j] <= 10; // Condición de aprobado
                if (aprobo == aprobados) { // Cuenta según se pidan aprobados o reprobados
                    conteo[j]++; // Suma uno al contador de la materia
                }
            }
        }
        return conteo; // Devuelve los contadores de todas las materias
    }

    // Muestra un mensaje, lee una línea de la consola y la convierte a entero
    static int leerEntero(String mensaje) {
        return Integer.parseInt(IO.readln(mensaje));
    }

    static void main() {
        int n = leerEntero("Número de estudiantes (N): "); // Lee la cantidad de estudiantes
        int[] codigos = new int[n]; // Código de cada estudiante
        for (int i = 0; i < n; i++) { // Recorre los estudiantes para asignar su código
            codigos[i] = 1001 + i; // Códigos consecutivos: 1001, 1002, ...
        }
        double[][] notas = generarNotas(n); // Genera las calificaciones de todos los estudiantes

        IO.println(); // Línea en blanco antes de la tabla
        IO.println("=== CALIFICACIONES FINALES ==="); // Título de la tabla
        imprimirNotas(codigos, notas); // Muestra la tabla de notas

        // a) Promedio por estudiante
        double[] promEstudiantes = promedioPorEstudiante(notas); // Calcula los promedios por estudiante
        IO.println("=== a) PROMEDIO POR ESTUDIANTE ==="); // Título de la sección
        for (int i = 0; i < n; i++) { // Recorre cada estudiante
            IO.println(String.format("Estudiante %d: %.2f", codigos[i], promEstudiantes[i])); // Imprime su promedio
        }
        IO.println(); // Línea en blanco

        // b) Promedio por materia
        double[] promMaterias = promedioPorMateria(notas); // Calcula los promedios por materia
        IO.println("=== b) PROMEDIO POR MATERIA ==="); // Título de la sección
        for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia
            IO.println(String.format("Materia %d: %.2f", j + 1, promMaterias[j])); // Imprime su promedio
        }
        IO.println(); // Línea en blanco

        // c) Estudiante con mayor promedio
        int mejor = mejorEstudiante(promEstudiantes); // Obtiene la posición del mejor estudiante
        IO.println("=== c) ESTUDIANTE CON MAYOR PROMEDIO ==="); // Título de la sección
        IO.println(String.format("Estudiante %d con promedio %.2f", codigos[mejor], promEstudiantes[mejor])); // Muestra el resultado
        IO.println(); // Línea en blanco

        // d) y e) Aprobados y reprobados por materia
        int[] aprobados = contarPorMateria(notas, true); // Cuenta los aprobados por materia
        int[] reprobados = contarPorMateria(notas, false); // Cuenta los reprobados por materia
        IO.println("=== d) APROBADOS y e) REPROBADOS POR MATERIA ==="); // Título de la sección
        for (int j = 0; j < MATERIAS; j++) { // Recorre cada materia
            IO.println(String.format("Materia %d: aprobados = %d, reprobados = %d", j + 1, aprobados[j], reprobados[j])); // Muestra ambos conteos
        }
    }
}
