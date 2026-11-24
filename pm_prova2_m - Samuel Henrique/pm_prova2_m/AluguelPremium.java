package pm_prova2_m;

public class AluguelPremium extends Aluguel {

    public AluguelPremium(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- ALUGUEL PREMIUM -----");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Quantidade de dias: " + getQuantidadeDias());
        System.out.println("Valor total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: ilimitada");
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Não"));
        exibirVeiculos();
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return true;
    }

}
