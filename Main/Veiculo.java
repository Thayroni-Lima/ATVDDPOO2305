import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Veiculo {
    private String placa;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public void registrarEntrada() {
        this.horaEntrada = LocalDateTime.now();
    }

    public void registrarSaida() {
        this.horaSaida = LocalDateTime.now();
    }

    public long calcularTempoEstacionamento() {
        if (horaEntrada != null && horaSaida != null) {
            return Duration.between(horaEntrada, horaSaida).toHours();
        } else {
            return 0;
        }
    }

    public abstract double calcularValorPago();

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
