package pedido.restaurante10;

import java.util.ArrayList;

public class PedidoRestaurante10 {
    void main() {

        // Lista donde se almacenarán los pedidos.
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Ejecuta las funciones del programa.
        registrarPedidos(pedidos);
        calcularTotalPedidos(pedidos);
        calcularIngresoTotal(pedidos);
        mostrarPedidoMayorValor(pedidos);
    }


    // Registra varios pedidos en la lista.
    static void registrarPedidos(ArrayList<Pedido> pedidos) {

        // Variable para controlar el registro.
        String continuar = "si";

        // Permite registrar varios pedidos.
        while (continuar.equalsIgnoreCase("si")) {

            // Solicita los datos del pedido.
            String nombreCliente = IO.readln("Ingrese el nombre del cliente: ");

            String platoSolicitado = IO.readln("Ingrese el plato solicitado: ");

            Integer cantidad = Integer.parseInt(
                    IO.readln("Ingrese la cantidad: "));

            Double precioUnitario = Double.parseDouble(
                    IO.readln("Ingrese el precio unitario: "));

            // Crea un objeto con los datos ingresados.
            Pedido pedido = new Pedido(
                    nombreCliente, platoSolicitado, cantidad, precioUnitario);

            // Agrega el pedido a la lista.
            pedidos.add(pedido);

            // Pregunta si desea registrar otro pedido.
            continuar = IO.readln("¿Desea registrar otro pedido? (si/no): ");
        }
    }


    // Calcula el total a pagar por cada pedido y aplica el descuento.
    static void calcularTotalPedidos(ArrayList<Pedido> pedidos) {

        IO.println("-------- TOTAL DE CADA PEDIDO --------");

        // Variable para recorrer la lista.
        int i = 0;

        // Recorre todos los pedidos.
        while (i < pedidos.size()) {

            // Obtiene el pedido actual.
            Pedido pedido = pedidos.get(i);

            // Calcula el precio total del pedido.
            Double total = pedido.getCantidad() * pedido.getPrecioUnitario();

            // Aplica el descuento del 10% si supera los 50 dólares.
            if (total > 50) {
                total = total - (total * 0.10);
            }

            // Muestra el total a pagar.
            IO.println("Cliente: %s".formatted(pedido.getNombreCliente()));
            IO.println("Plato: %s".formatted(pedido.getPlatoSolicitado()));
            IO.println("Total a pagar: $%s".formatted(total));

            // Pasa al siguiente pedido.
            i++;
        }
    }


    // Calcula el ingreso total del restaurante.
    static void calcularIngresoTotal(ArrayList<Pedido> pedidos) {

        IO.println("-------- INGRESO TOTAL DEL RESTAURANTE --------");

        // Variable que acumula los ingresos.
        Double ingresoTotal = 0.0;

        // Variable para recorrer la lista.
        int i = 0;

        // Recorre todos los pedidos.
        while (i < pedidos.size()) {

            // Obtiene el pedido actual.
            Pedido pedido = pedidos.get(i);

            // Calcula el total del pedido.
            Double total = pedido.getCantidad() * pedido.getPrecioUnitario();

            // Aplica el descuento correspondiente.
            if (total > 50) {
                total = total - (total * 0.10);
            }

            // Suma el pedido al ingreso total.
            ingresoTotal += total;

            // Pasa al siguiente pedido.
            i++;
        }

        // Muestra el ingreso total del restaurante.
        IO.println("Ingreso total: $%s".formatted(ingresoTotal));
    }


    // Muestra el pedido de mayor valor.
    static void mostrarPedidoMayorValor(ArrayList<Pedido> pedidos) {

        IO.println("-------- PEDIDO DE MAYOR VALOR --------");

        // Variable que almacena el pedido de mayor valor.
        Pedido pedidoMayor = pedidos.get(0);

        // Calcula el valor inicial del pedido.
        Double mayorValor = pedidoMayor.getCantidad()
                * pedidoMayor.getPrecioUnitario();

        // Aplica el descuento inicial si corresponde.
        if (mayorValor > 50) {
            mayorValor = mayorValor - (mayorValor * 0.10);
        }

        // Variable para recorrer la lista.
        int i = 1;

        // Recorre los demás pedidos.
        while (i < pedidos.size()) {

            // Obtiene el pedido actual.
            Pedido pedido = pedidos.get(i);

            // Calcula el total del pedido.
            Double total = pedido.getCantidad()
                    * pedido.getPrecioUnitario();

            // Aplica el descuento si corresponde.
            if (total > 50) {
                total = total - (total * 0.10);
            }

            // Comprueba si el pedido actual supera al mayor valor.
            if (total > mayorValor) {

                // Actualiza el pedido de mayor valor.
                mayorValor = total;
                pedidoMayor = pedido;
            }

            // Pasa al siguiente pedido.
            i++;
        }

        // Muestra la información del pedido de mayor valor.
        IO.println("Cliente: %s".formatted(pedidoMayor.getNombreCliente()));
        IO.println("Plato: %s".formatted(pedidoMayor.getPlatoSolicitado()));
        IO.println("Cantidad: %s".formatted(pedidoMayor.getCantidad()));
        IO.println("Precio unitario: $%s".formatted(pedidoMayor.getPrecioUnitario()));
        IO.println("Total del pedido: $%s".formatted(mayorValor));
    }
}
