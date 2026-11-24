package pm_prova2_m;

import java.util.ArrayList;
import java.util.Scanner;

public class PM_Prova2_M {

    static ArrayList<Veiculo> veiculos = new ArrayList<>();
    static ArrayList<Aluguel> alugueis = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDados();

        int opcao;
        do {
            System.out.println();
            System.out.println("===== LOCADORA DE VEÍCULOS =====");
            System.out.println("1 - Associar veículo a um aluguel");
            System.out.println("2 - Exibir todos os veículos");
            System.out.println("3 - Exibir todos os aluguéis");
            System.out.println("4 - Exibir veículos disponíveis");
            System.out.println("5 - Avaliar");
            System.out.println("6 - Realizar inspeção");
            System.out.println("7 - Remover veículos em manutenção");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    associarVeiculo();
                    break;
                case 2:
                    exibirVeiculos();
                    break;
                case 3:
                    exibirAlugueis();
                    break;
                case 4:
                    exibirDisponiveis();
                    break;
                case 5:
                    avaliar();
                    break;
                case 6:
                    realizarInspecao();
                    break;
                case 7:
                    removerManutencao();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void carregarDados() {
        veiculos.add(new Carro("AAA1A23", "Gol", 2018, 80.0, 80000, StatusVeiculo.DISPONIVEL, 4));
        veiculos.add(new Moto("ABC1D23", "CG 160", 2020, 90.0, 28000, StatusVeiculo.MANUTENCAO, 160));
        veiculos.add(new Van("XYZ1A23", "VAN", 2015, 200.0, 100000, StatusVeiculo.DISPONIVEL, 10));

        alugueis.add(new AluguelBasico("Samuel Henrique", 3, 0, StatusAluguel.ATIVO));
        alugueis.add(new AluguelExecutivo("Henrique Lopes", 5, 0, StatusAluguel.ATIVO, "Humberto"));
    }

    public static void associarVeiculo() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }

        System.out.println("Aluguéis:");
        for (int i = 0; i < alugueis.size(); i++) {
            System.out.println(i + " - " + alugueis.get(i).getNomeCliente());
        }
        System.out.print("Escolha o aluguel: ");
        int indiceAluguel = sc.nextInt();

        if (indiceAluguel < 0 || indiceAluguel >= alugueis.size()) {
            System.out.println("Aluguel inválido!");
            return;
        }

        ArrayList<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                disponiveis.add(v);
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
            return;
        }

        System.out.println("Veículos disponíveis:");
        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println(i + " - " + disponiveis.get(i).getModelo() + " (" + disponiveis.get(i).getPlaca() + ")");
        }
        System.out.print("Escolha o veículo: ");
        int indiceVeiculo = sc.nextInt();

        if (indiceVeiculo < 0 || indiceVeiculo >= disponiveis.size()) {
            System.out.println("Veículo inválido!");
            return;
        }

        Aluguel aluguel = alugueis.get(indiceAluguel);
        Veiculo veiculo = disponiveis.get(indiceVeiculo);
        aluguel.adicionarVeiculo(veiculo);
        System.out.println("Veículo " + veiculo.getModelo() + " associado ao aluguel de " + aluguel.getNomeCliente() + ".");
    }

    public static void exibirVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (Veiculo v : veiculos) {
            v.exibirDetalhes();
            System.out.println();
        }
    }

    public static void exibirAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel cadastrado.");
            return;
        }
        for (Aluguel a : alugueis) {
            a.exibirDetalhes();
            System.out.println();
        }
    }

    public static void exibirDisponiveis() {
        boolean encontrou = false;
        for (Veiculo v : veiculos) {
            if (v.getStatus() == StatusVeiculo.DISPONIVEL) {
                v.exibirDetalhes();
                System.out.println();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum veículo disponível.");
        }
    }

    public static void avaliar() {
        ArrayList<Avaliavel> avaliaveis = new ArrayList<>();

        System.out.println("Itens que podem ser avaliados:");
        for (Veiculo v : veiculos) {
            if (v instanceof Avaliavel) {
                System.out.println(avaliaveis.size() + " - Veículo: " + v.getModelo() + " (" + v.getPlaca() + ")");
                avaliaveis.add((Avaliavel) v);
            }
        }
        for (Aluguel a : alugueis) {
            if (a instanceof Avaliavel) {
                System.out.println(avaliaveis.size() + " - Aluguel de " + a.getNomeCliente());
                avaliaveis.add((Avaliavel) a);
            }
        }

        if (avaliaveis.isEmpty()) {
            System.out.println("Nenhum item pode ser avaliado.");
            return;
        }

        System.out.print("Escolha o item: ");
        int indice = sc.nextInt();

        if (indice < 0 || indice >= avaliaveis.size()) {
            System.out.println("Item inválido!");
            return;
        }

        System.out.print("Digite a nota (0 a 10): ");
        int nota = sc.nextInt();
        avaliaveis.get(indice).avaliar(nota);
    }

    public static void realizarInspecao() {
        boolean encontrou = false;
        for (Veiculo v : veiculos) {
            if (v instanceof Inspecionavel) {
                Inspecionavel i = (Inspecionavel) v;
                i.realizarInspecao();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum veículo pode ser inspecionado.");
        }
    }

    public static void removerManutencao() {
        int removidos = 0;
        for (int i = veiculos.size() - 1; i >= 0; i--) {
            Veiculo v = veiculos.get(i);
            if (v.getStatus() == StatusVeiculo.MANUTENCAO) {
                for (Aluguel a : alugueis) {
                    a.removerVeiculo(v);
                }
                System.out.println("Veículo " + v.getModelo() + " (" + v.getPlaca() + ") removido.");
                veiculos.remove(i);
                removidos++;
            }
        }
        if (removidos == 0) {
            System.out.println("Nenhum veículo em manutenção.");
        }
    }

}
