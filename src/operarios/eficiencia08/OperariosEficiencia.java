package operarios.eficiencia08;

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

    static int calculoEficiencia(OperarioInterface operario) {
        if (operario.getHorasAusencia() <= 3 && operario.getTotalPupitresDefectuosos() < 300
                && operario.getTotalPupitresProducidos() > 1000) {
            return 20;
        } else if (operario.getTotalPupitresDefectuosos() < 300 && operario.getTotalPupitresProducidos() > 1000) {
            return 15;
        } else if (operario.getHorasAusencia() <= 3 && operario.getTotalPupitresProducidos() > 1000) {
            return 13;
        } else if (operario.getHorasAusencia() <= 3 && operario.getTotalPupitresDefectuosos() < 300) {
            return 12;
        } else if (operario.getTotalPupitresProducidos() > 1000) {
            return 9;
        } else if (operario.getTotalPupitresDefectuosos() < 300) {
            return 8;
        } else if (operario.getHorasAusencia() <= 3) {
            return 7;
        } else {
            return 5;
        }
    }

    static void imprimirInfo(ArrayList<OperarioInterface> operarios) {
        IO.println("-------- OPERARIOS --------");
        for (OperarioInterface operario: operarios) {
            IO.println("CODIGO %s".formatted(operario.getCodigo()));
            IO.println("Horas ausentes %s".formatted(operario.getHorasAusencia()));
            IO.println("Pupitres defectuosos %s".formatted(operario.getTotalPupitresDefectuosos()));
            IO.println("Pupitres producidos %s".formatted(operario.getTotalPupitresProducidos()));
            IO.println("EFICIENCIA %s".formatted(operario.getEficiencia()));
        }
    }
}
