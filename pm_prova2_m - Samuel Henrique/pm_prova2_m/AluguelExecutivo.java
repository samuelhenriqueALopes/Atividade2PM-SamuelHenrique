package pm_prova2_m;

public class AluguelExecutivo extends Aluguel implements Avaliavel {

    private String nomeMotorista;
    private int nota;

    public AluguelExecutivo(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status, String nomeMotorista) {
        super(nomeCliente, quantidadeDias, valorTotal, status);
        this.nomeMotorista = nomeMotorista;
        this.nota = 0;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            System.out.println("Aluguel executivo de " + getNomeCliente() + " avaliado com nota " + nota + ".");
        } else {
            System.out.println("Nota inválida! Digite um valor de 0 a 10.");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- ALUGUEL EXECUTIVO -----");
        System.out.println("Cliente: " + getNomeCliente());
        System.out.println("Quantidade de dias: " + getQuantidadeDias());
        System.out.println("Valor total: R$ " + getValorTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("Quilometragem: ilimitada");
        System.out.println("Motorista particular: " + nomeMotorista);
        System.out.println("Nota: " + nota);
        System.out.println("Seguro incluso: " + (possuiSeguroIncluso() ? "Sim" : "Não"));
        exibirVeiculos();
    }

    @Override
    public boolean possuiSeguroIncluso() {
        return false;
    }

}
