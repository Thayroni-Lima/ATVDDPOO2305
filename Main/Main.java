import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(10);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar veículo");
            System.out.println("2. Remover veículo");
            System.out.println("3. Ver vagas disponíveis");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo de veículo (Carro/Moto):");
                    String tipo = scanner.nextLine();
                    System.out.println("Digite a placa do veículo:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite a hora de entrada (dd/MM/yyyy HH:mm):");
                    String entradaStr = scanner.nextLine();
                    LocalDateTime horaEntrada = LocalDateTime.parse(entradaStr, formatter);

                    Veiculo veiculo;
                    if (tipo.equalsIgnoreCase("Carro")) {
                        veiculo = new Carro(placa);
                    } else if (tipo.equalsIgnoreCase("Moto")) {
                        veiculo = new Moto(placa);
                    } else {
                        System.out.println("Tipo de veículo inválido!");
                        continue;
                    }

                    veiculo.setHoraEntrada(horaEntrada);
                    if (estacionamento.adicionarVeiculo(veiculo)) {
                        System.out.println("Veículo adicionado com sucesso!");
                    } else {
                        System.out.println("Estacionamento cheio!");
                    }
                    break;

                case 2:
                    System.out.println("Digite a placa do veículo:");
                    String placaSaida = scanner.nextLine();
                    System.out.println("Digite a hora de saída (dd/MM/yyyy HH:mm):");
                    String saidaStr = scanner.nextLine();
                    LocalDateTime horaSaida = LocalDateTime.parse(saidaStr, formatter);

                    if (estacionamento.removerVeiculo(placaSaida, horaSaida)) {
                        System.out.println("Veículo removido com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("Vagas disponíveis: " + estacionamento.vagasDisponiveis());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
