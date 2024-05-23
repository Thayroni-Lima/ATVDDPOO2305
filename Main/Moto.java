public class Moto extends Veiculo {
    private static final double TARIFA_POR_HORA = 2.50;

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public double calcularValorPago() {
        long horas = calcularTempoEstacionamento();
        return horas * TARIFA_POR_HORA;
    }
}
