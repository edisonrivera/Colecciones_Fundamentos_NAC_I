package inventario.famarcia09;

import java.util.ArrayList;

public class InventarioFarmacia09 {

    void main() {

        // Lista donde se almacenarán los medicamentos.
        ArrayList<Medicamento> medicamentos = new ArrayList<>();

        // Ejecuta las funciones del inventario.
        registrarMedicamentos(medicamentos);
        mostrarStockBajo(medicamentos);
        calcularValorTotal(medicamentos);
        actualizarStock(medicamentos);
        imprimirInfo(medicamentos);
    }


    // Registra varios medicamentos en la lista.
    static void registrarMedicamentos(ArrayList<Medicamento> medicamentos) {

        // Variable para controlar el registro.
        String continuar = "si";

        // Permite registrar varios medicamentos.
        while (continuar.equalsIgnoreCase("si")) {

            // Solicita los datos del medicamento.
            String nombre = IO.readln("Ingrese el nombre del medicamento: ");

            Integer stockActual = Integer.parseInt(
                    IO.readln("Ingrese el stock actual: "));

            Integer stockMinimo = Integer.parseInt(
                    IO.readln("Ingrese el stock mínimo: "));

            Double precioUnitario = Double.parseDouble(
                    IO.readln("Ingrese el precio unitario: "));

            // Crea un objeto con los datos ingresados.
            Medicamento medicamento = new Medicamento(
                    nombre, stockActual, stockMinimo, precioUnitario);

            // Agrega el medicamento a la lista.
            medicamentos.add(medicamento);

            // Pregunta si desea registrar otro medicamento.
            continuar = IO.readln("¿Desea registrar otro medicamento? (si/no): ");
        }
    }


    // Muestra los medicamentos cuyo stock está por debajo del mínimo.
    static void mostrarStockBajo(ArrayList<Medicamento> medicamentos) {

        IO.println("-------- MEDICAMENTOS CON STOCK BAJO --------");

        // Recorre todos los medicamentos.
        for (Medicamento medicamento : medicamentos) {

            // Obtiene el medicamento actual.
            // Comprueba si el stock está por debajo del mínimo.
            if (medicamento.getStockActual() < medicamento.getStockMinimo()) {

                // Muestra los datos del medicamento.
                IO.println("Nombre: %s".formatted(medicamento.getNombre()));
                IO.println("Stock actual: %s".formatted(medicamento.getStockActual()));
                IO.println("Stock mínimo: %s".formatted(medicamento.getStockMinimo()));
            }
        }
    }


    // Calcula el valor económico total del inventario.
    static void calcularValorTotal(ArrayList<Medicamento> medicamentos) {

        IO.println("-------- VALOR TOTAL DEL INVENTARIO --------");

        // Variable que acumula el valor de todos los medicamentos.
        double valorTotal = 0.0;

        // Recorre todos los medicamentos.
        for (Medicamento medicamento : medicamentos) {

            // Calcula el valor de las unidades disponibles.
            double valorMedicamento = medicamento.getStockActual()
                    * medicamento.getPrecioUnitario();

            // Suma el valor del medicamento al total.
            valorTotal += valorMedicamento;
        }

        // Muestra el valor económico total.
        IO.println("Valor total: $%s".formatted(valorTotal));
    }


    // Actualiza el stock después de realizar una venta.
    static void actualizarStock(ArrayList<Medicamento> medicamentos) {

        IO.println("-------- REGISTRAR VENTA --------");

        // Solicita los datos de la venta.
        String nombreVenta = IO.readln("Ingrese el nombre del medicamento: ");

        Integer cantidadVendida = Integer.parseInt(IO.readln("Ingrese la cantidad vendida: "));

        // Comprueba si el medicamento existe.
        boolean encontrado = false;

        // Recorre los medicamentos registrados.
        for (Medicamento medicamento : medicamentos) {

            // Comprueba si el nombre coincide.
            if (medicamento.getNombre().equalsIgnoreCase(nombreVenta)) {

                // Comprueba que exista suficiente stock.
                if (cantidadVendida > 0 && cantidadVendida <= medicamento.getStockActual()) {

                    // Resta las unidades vendidas al stock actual.
                    medicamento.setStockActual(medicamento.getStockActual() - cantidadVendida);

                    IO.println("Venta realizada correctamente.");
                    IO.println("Nuevo stock: %s".formatted(medicamento.getStockActual()));

                } else {

                    // Informa que la cantidad no es válida.
                    IO.println("Cantidad no válida o stock insuficiente.");
                }

                encontrado = true;
            }
        }

        // Informa si el medicamento no existe.
        if (!encontrado) {
            IO.println("Medicamento no encontrado.");
        }
    }


    // Muestra el reporte general de todos los medicamentos.
    static void imprimirInfo(ArrayList<Medicamento> medicamentos) {

        IO.println("-------- REPORTE GENERAL DEL INVENTARIO --------");

        // Recorre todos los medicamentos registrados.
        for (Medicamento medicamento: medicamentos) {

            // Muestra toda la información del medicamento.
            IO.println("Nombre: %s".formatted(medicamento.getNombre()));
            IO.println("Stock actual: %s".formatted(medicamento.getStockActual()));
            IO.println("Stock mínimo: %s".formatted(medicamento.getStockMinimo()));
            IO.println("Precio unitario: $%s".formatted(medicamento.getPrecioUnitario()));

            IO.println("--------------------------------");
        }
    }
}