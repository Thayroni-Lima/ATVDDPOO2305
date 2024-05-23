import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Estacionamento {
    private int capacidade;
    private List<Veiculo> veiculosEstacionados;

    public Estacionamento(int capacidade) {
        this.capacidade = capacidade;
        this.veiculosEstacionados = new ArrayList<>();
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {
        if (veiculosEstacionados.size() < capacidade) {
            veiculo.registrarEntrada();
            veiculosEstacionados.add(veiculo);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerVeiculo(String placa, LocalDateTime horaSaida) {
        for (Veiculo veiculo : veiculosEstacionados) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida(horaSaida);
                veiculosEstacionados.remove(veiculo);
                System.out.println("Valor a ser pago: " + veiculo.calcularValorPago());
                return true;
            }
        }
        return false;
    }

    public int vagasDisponiveis() {
        return capacidade - veiculosEstacionados.size();
    }
}
