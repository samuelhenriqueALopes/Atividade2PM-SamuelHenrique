package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int nota;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
        this.nota = 0;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Carro " + getModelo() + " avaliado com nota " + nota + ".");
        } else {
            System.out.println("Nota inválida! Digite um valor de 0 a 10.");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- CARRO -----");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano de fabricação: " + getAnoFabricacao());
        System.out.println("Valor da diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km");
        System.out.println("Status: " + getStatus());
        System.out.println("Quantidade de portas: " + quantidadePortas);
        System.out.println("Nota: " + nota);
        System.out.println("Seguro especial: " + (possuiSeguroEspecial() ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }

}
