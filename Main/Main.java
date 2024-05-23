public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(10);

        Veiculo carro1 = new Carro("ABC-1234");
        Veiculo moto1 = new Moto("XYZ-5678");

        // Adicionando veículos
        estacionamento.adicionarVeiculo(carro1);
        estacionamento.adicionarVeiculo(moto1);

        // Exibindo vagas disponíveis
        System.out.println("Vagas disponíveis: " + estacionamento.vagasDisponiveis());

        // Simulando a saída de veículos após algum tempo
        try {
            Thread.sleep(2000); // Simulando tempo de permanência
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        estacionamento.removerVeiculo("ABC-1234");
        estacionamento.removerVeiculo("XYZ-5678");

        // Exibindo vagas disponíveis novamente
        System.out.println("Vagas disponíveis: " + estacionamento.vagasDisponiveis());
    }
}
