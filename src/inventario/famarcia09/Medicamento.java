package inventario.famarcia09;

// Clase que almacena la información de cada medicamento.
public class Medicamento {

    // Atributos que guardan los datos del medicamento.
    private final String nombre;
    private Integer stockActual;
    private final Integer stockMinimo;
    private final Double precioUnitario;

    // Métodos para obtener la información del medicamento.
    public String getNombre() {
        return nombre;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    // Método para actualizar el stock.
    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    // Constructor que recibe los datos del medicamento.
    Medicamento(String nombre, Integer stockActual, Integer stockMinimo, Double precioUnitario) {
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.precioUnitario = precioUnitario;
    }
}