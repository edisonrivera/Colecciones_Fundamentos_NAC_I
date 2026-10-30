package operario.eficiencia08;

public class OperarioInterface {
    // Declara las varibales
    // Todas son privadas y su valor no puede modificarse después de asignarse.
    private final Integer codigo;
    private final Integer horasAusencia;
    private final Integer totalPupitresDefectuosos;
    private final Integer totalPupitresProducidos;

    // Declara una variable para almacenar la eficiencia del operario.
    private Integer eficiencia;


    // Método que permite obtener el código del operario.
    public Integer getCodigo() {
        // Devuelve el valor almacenado en "codigo".
        return codigo;
    }


    // Metodo que permite obtener la cantidad de pupitres defectuosos.
    public Integer getTotalPupitresDefectuosos() {
        // Devuelve el valor de totalPupitresDefectuosos.
        return totalPupitresDefectuosos;
    }


    // Metodo que permite obtener la cantidad de pupitres producidos.
    public Integer getTotalPupitresProducidos() {
        // Devuelve el valor de totalPupitresProducidos.
        return totalPupitresProducidos;
    }


    // Metodo que permite obtener la eficiencia del operario.
    public Integer getEficiencia() {
        // Devuelve el valor actual de eficiencia.
        return eficiencia;
    }


    // Metodo que permite modificar la eficiencia.
    public void setEficiencia(Integer eficiencia) {
        // Asigna el valor recibido como parámetro a la variable eficiencia de la clase.
        this.eficiencia = eficiencia;
    }


    // Metodo que permite obtener las horas de ausencia.
    public Integer getHorasAusencia() {
        // Devuelve el número de horas que el operario estuvo ausente.
        return horasAusencia;
    }


    // Constructor de la clase.
    // Recibe los datos necesarios para crear un objeto OperarioInterface.
    OperarioInterface(
            Integer codigo,
            Integer horasAusencia,
            Integer totalPupitresDefectuosos,
            Integer totalPupitresProducidos) {

        // Guarda el código recibido dentro del atributo "codigo".
        this.codigo = codigo;

        // Guarda las horas de ausencia recibidas
        this.horasAusencia = horasAusencia;

        // Guarda la cantidad de pupitres defectuosos recibida
        this.totalPupitresDefectuosos = totalPupitresDefectuosos;

        // Guarda la cantidad de pupitres producidos recibida
        this.totalPupitresProducidos = totalPupitresProducidos;
    }
}
