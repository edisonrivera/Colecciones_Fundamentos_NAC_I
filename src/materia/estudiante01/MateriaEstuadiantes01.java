package materia.estudiante01;


import java.util.ArrayList;
import java.util.Objects;

public class MateriaEstuadiantes01 {
    void main() {
        // Leer el tamaño del array
        int tamanio = Integer.parseInt(IO.readln("Ingrese el tamaño para los dos arreglos: "));

        // Definir los array de materias con el tamaño
        String[] reprobadosMatematica = new String[tamanio];
        String[] reprobadosIngles = new String[tamanio];
        
        // Definir el tercer array con el código de estudiante que reprobaron las dos materias
        ArrayList<String> reprobadosDosMaterias =  new ArrayList<>();

        // Solicita los estudiantes que reprobaron matemática
        IO.println("----------------ESTUDIANTES QUE REPROBARON MATEMATICA------------");
        for (int i = 0; i < tamanio; i++) {
            // Se lee desde el teclado el ci del estudiante
            reprobadosMatematica[i] = IO.readln("Ingrese el ci del estudiante %s %s".formatted(String.valueOf(i+1),": "));
        }

        // Solicita los estudiantes que reprobaron ingles
        IO.println("----------------ESTUDIANTES QUE REPROBARON INGLES------------");
        for (int i = 0; i < tamanio; i++) {
            // Se lee desde el teclado el ci del estudiante
            reprobadosIngles[i] = IO.readln("Ingrese el ci de lestudiante %s %s".formatted(String.valueOf(i+1),": "));
        }

        // Obtener estudiantes que reprobaron en dos materias
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                if (Objects.equals(reprobadosMatematica[i], reprobadosIngles[j])) {
                    reprobadosDosMaterias.add(reprobadosMatematica[i]);
                    break;
                }
            }
        }   

        // Imprimir los tres vectores
        IO.println("----ESTUDIANTES QUE REPROBARON DOS MATERIAS------------");
        for (String reprobados : reprobadosDosMaterias) {
            //Se imprime cada valor del array
            IO.println(reprobados);
        }

        IO.println("----ESTUDIANTES QUE REPROBARON MATEMATICAS------------");
        for (int i = 0; i < tamanio; i++) {
            //Se imprime cada valor del array
            IO.println(reprobadosMatematica[i]);
        }

        IO.println("----ESTUDIANTES QUE REPROBARON INGLES------------");
        for (int i = 0; i < tamanio; i++) {
            //Se imprime cada valor del array
            IO.println(reprobadosIngles[i]);
        }
    }
}
