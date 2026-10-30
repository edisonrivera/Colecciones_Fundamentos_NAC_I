package pedido.restaurante10;

public class Pedido {

    // Atributos que almacenan la información del pedido.
    private final String nombreCliente;
    private final String platoSolicitado;
    private final Integer cantidad;
    private final Double precioUnitario;

    // Método para obtener el nombre del cliente.
    public String getNombreCliente() {
        return nombreCliente;
    }

    // Método para obtener el plato solicitado.
    public String getPlatoSolicitado() {
        return platoSolicitado;
    }

    // Método para obtener la cantidad.
    public Integer getCantidad() {
        return cantidad;
    }

    // Método para obtener el precio unitario.
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    // Constructor que recibe los datos del pedido.
    Pedido(String nombreCliente, String platoSolicitado,
           Integer cantidad, Double precioUnitario) {

        this.nombreCliente = nombreCliente;
        this.platoSolicitado = platoSolicitado;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
