package operarios.eficiencia08;

public class OperarioInterface {
    private final Integer codigo;
    private final Integer horasAusencia;
    private final Integer totalPupitresDefectuosos;
    private final Integer totalPupitresProducidos;
    private Integer eficiencia;

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getTotalPupitresDefectuosos() {
        return totalPupitresDefectuosos;
    }

    public Integer getTotalPupitresProducidos() {
        return totalPupitresProducidos;
    }

    public Integer getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(Integer eficiencia) {
        this.eficiencia = eficiencia;
    }

    public Integer getHorasAusencia() {
        return horasAusencia;
    }

    OperarioInterface(Integer codigo, Integer horasAusencia, Integer totalPupitresDefectuosos, Integer totalPupitresProducidos) {
        this.codigo = codigo;
        this.horasAusencia = horasAusencia;
        this.totalPupitresDefectuosos = totalPupitresDefectuosos;
        this.totalPupitresProducidos = totalPupitresProducidos;
    }
}
