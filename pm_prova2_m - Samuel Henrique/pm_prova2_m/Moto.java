package pm_prova2_m;

public class Moto extends Veiculo implements Inspecionavel {

    private int cilindrada;
    private boolean inspecionada;

    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, StatusVeiculo status, int cilindrada) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
        this.inspecionada = false;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isInspecionada() {
        return inspecionada;
    }

    @Override
    public void realizarInspecao() {
        inspecionada = true;
        System.out.println("Inspeção realizada na moto " + getModelo() + " (" + getPlaca() + ").");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("----- MOTO -----");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano de fabricação: " + getAnoFabricacao());
        System.out.println("Valor da diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km");
        System.out.println("Status: " + getStatus());
        System.out.println("Cilindrada: " + cilindrada + " cc");
        System.out.println("Inspecionada: " + (inspecionada ? "Sim" : "Não"));
        System.out.println("Seguro especial: " + (possuiSeguroEspecial() ? "Sim" : "Não"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }

}
