public class Carro extends Veiculo {
    private static final double TARIFA_POR_HORA = 5.00;

    public Carro(String placa) {
        super(placa);
    }

    @Override
    public double calcularValorPago() {
        long horas = calcularTempoEstacionamento();
        return horas * TARIFA_POR_HORA;
    }
}
