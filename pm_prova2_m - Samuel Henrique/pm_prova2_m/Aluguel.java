package pm_prova2_m;

import java.util.ArrayList;

public abstract class Aluguel {

    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;
    private ArrayList<Veiculo> veiculos;

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {

        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
        this.veiculos = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        veiculo.setStatus(StatusVeiculo.ALUGADO);
        valorTotal = valorTotal + (veiculo.getValorDiaria() * quantidadeDias);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo associado.");
        } else {
            System.out.println("Veículos associados:");
            for (Veiculo v : veiculos) {
                System.out.println(" - " + v.getModelo() + " (" + v.getPlaca() + ")");
            }
        }
    }

    public abstract void exibirDetalhes();

    public abstract boolean possuiSeguroIncluso();

}
