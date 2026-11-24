package pm_prova2_m;

public class AluguelBasico extends Aluguel {

    private int limiteKmPorDia;

    public AluguelBasico(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.limiteKmPorDia = 100;
    }

    public int getLimiteKmPorDia() {
        return limiteKmPorDia;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- ALUGUEL BÁSICO -----");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Quantidade de dias: " + getQuantidadeDias());
        System.out.println("Valor total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: até " + limiteKmPorDia + " km por dia");
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Não"));
        exibirVeiculos();
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

}
