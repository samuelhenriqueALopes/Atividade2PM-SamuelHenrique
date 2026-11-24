package pm_prova2_m;

public class Van extends Veiculo implements Avaliavel, Inspecionavel {

    private int quantidadeMaximaPassageiros;
    private int nota;
    private boolean inspecionada;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int quantidadeMaximaPassageiros) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadeMaximaPassageiros = quantidadeMaximaPassageiros;
        this.nota = 0;
        this.inspecionada = false;
    }

    public int getQuantidadeMaximaPassageiros() {
        return quantidadeMaximaPassageiros;
    }

    public void setQuantidadeMaximaPassageiros(int quantidadeMaximaPassageiros) {
        this.quantidadeMaximaPassageiros = quantidadeMaximaPassageiros;
    }

    public int getNota() {
        return nota;
    }

    public boolean isInspecionada() {
        return inspecionada;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Van " + getModelo() + " avaliada com nota " + nota + ".");
        } else {
            System.out.println("Nota inválida! Digite um valor de 0 a 10.");
        }
    }

    @Override
    public void realizarInspecao() {
        inspecionada = true;
        System.out.println("Inspeção realizada na van " + getModelo() + " (" + getPlaca() + ").");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- VAN -----");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano de fabricação: " + getAnoFabricacao());
        System.out.println("Valor da diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km");
        System.out.println("Status: " + getStatus());
        System.out.println("Máximo de passageiros: " + quantidadeMaximaPassageiros);
        System.out.println("Nota: " + nota);
        System.out.println("Inspecionada: " + (inspecionada ? "Sim" : "Não"));
        System.out.println("Seguro especial: " + (possuiSeguroEspecial() ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return true;
    }

}
