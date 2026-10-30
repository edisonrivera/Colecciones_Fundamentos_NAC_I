package operario.eficiencia08;

import java.util.ArrayList;

public class OperariosEficiencia {
    void main() {
        //Definir el numero de operarios
        int totalOperarios = Integer.parseInt(IO.readln("Ingrese el numero de operarios: "));

        //Definir el objeto estructural para operarios
        ArrayList<OperarioInterface> operarios = new ArrayList<>();

        //Solicitar datos de los operarios
        solicitarDatos(totalOperarios, operarios);

        //Evaluar las condiciones para definir la eficiencia de cada operario
        for (OperarioInterface operario : operarios) {
            int eficiencia = calculoEficiencia(operario);
            operario.setEficiencia(eficiencia);
        }

        //Imprimir la informacion con la eficiencia para cada operario
        imprimirInfo(operarios);

    }

    static void solicitarDatos(int totalOperarios, ArrayList<OperarioInterface> operarios) {
        // Agregar los datos para todos los operarios
        for (int i = 0; i < totalOperarios; i++) {
            IO.println("---- Ingrese los datos del operario %s".formatted(i + 1));
            //Leer el codigo del operador
            final var codigo = Integer.parseInt(IO.readln("Ingrese el codigo: "));
            //Leer las horas ausentes del operador
            final var horasAusente = Integer.parseInt(IO.readln("Ingrese el horas de ausente: "));
            //Leer cuantos pupitres defectuosos fabrico el operador
            final var pupitresDefectuosos = Integer.parseInt(IO.readln("Ingrese el total de pupitres de defectuosos: "));
            //Leer cuantos pupitres produjo el operador
            final var pupitresProducidos = Integer.parseInt(IO.readln("Ingrese el total de pupitres de producidos: "));

            //Se asigna el operario al array
            final var operario = new OperarioInterface(codigo,horasAusente,pupitresDefectuosos,pupitresProducidos);
            operarios.add(operario);
        }
    }

    // Calcula la eficiencia de un operario según sus datos.
    static int calculoEficiencia(OperarioInterface operario) {

        // Si cumple las tres condiciones principales, obtiene la mayor eficiencia.
        if (operario.getHorasAusencia() <= 3 &&
                operario.getTotalPupitresDefectuosos() < 300 &&
                operario.getTotalPupitresProducidos() > 1000) {
            return 20;

            // Cumple las condiciones de defectuosos y producción.
        } else if (operario.getTotalPupitresDefectuosos() < 300 &&
                operario.getTotalPupitresProducidos() > 1000) {
            return 15;

            // Cumple las condiciones de ausencia y producción.
        } else if (operario.getHorasAusencia() <= 3 &&
                operario.getTotalPupitresProducidos() > 1000) {
            return 13;

            // Cumple las condiciones de ausencia y defectuosos.
        } else if (operario.getHorasAusencia() <= 3 &&
                operario.getTotalPupitresDefectuosos() < 300) {
            return 12;

            // Solo cumple la condición de producción.
        } else if (operario.getTotalPupitresProducidos() > 1000) {
            return 9;

            // Solo cumple la condición de pupitres defectuosos.
        } else if (operario.getTotalPupitresDefectuosos() < 300) {
            return 8;

            // Solo cumple la condición de horas de ausencia.
        } else if (operario.getHorasAusencia() <= 3) {
            return 7;

            // Si no cumple ninguna de las condiciones anteriores.
        } else {
            return 5;
        }
    }


    // Muestra en pantalla la información de todos los operarios.
    static void imprimirInfo(ArrayList<OperarioInterface> operarios) {

        // Imprime el título de la información.
        IO.println("-------- OPERARIOS --------");

        // Recorre todos los operarios de la lista.
        for (OperarioInterface operario : operarios) {

            // Muestra el código del operario.
            IO.println("CODIGO %s".formatted(operario.getCodigo()));

            // Muestra sus horas de ausencia.
            IO.println("Horas ausentes %s".formatted(operario.getHorasAusencia()));

            // Muestra la cantidad de pupitres defectuosos.
            IO.println("Pupitres defectuosos %s".formatted(operario.getTotalPupitresDefectuosos()));

            // Muestra la cantidad de pupitres producidos.
            IO.println("Pupitres producidos %s".formatted(operario.getTotalPupitresProducidos()));

            // Muestra la eficiencia calculada.
            IO.println("EFICIENCIA %s".formatted(operario.getEficiencia()));
        }
    }
}
