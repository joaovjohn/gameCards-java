import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("\nDigite uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Jogar();
                case 2:
                    System.out.println("Saindo do jogo. Até mais!");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);
        scanner.close();
    }
    
    private static void Jogar() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner scanner = new Scanner(System.in);

        while (!tabuleiro.getJogadores().get(0).getCartas().isEmpty()) {
            limparTela();

            Tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiro());

            ArrayList<Carta> cartasDaRodada = new ArrayList<Carta>();

            System.out.println();

            for (Jogador jogador : tabuleiro.getJogadores()) {
                System.out.println("Mão do jogador " + jogador.getNome() + ": ");
                System.out.println(jogador.printHand());
                int indexOfCard = escolherCartaJogar(jogador.getCartas(), scanner);
                cartasDaRodada.add(jogador.getCartas().remove(indexOfCard));
            }

            Collections.sort(cartasDaRodada);
            System.out.println();

            System.out.println("Cartas jogadas essa rodada: ");
            for (Carta carta : cartasDaRodada) {
                System.out.print(carta.getNumero() + " ");
            }
            System.out.println();

            // criar uma função pra inserir as cartas

            tabuleiro.mostrarEstadoAtual();

            System.out.println("Pressione enter para continuar");

            scanner.nextLine();
        }
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int escolherCartaJogar(ArrayList<Carta> cartas, Scanner scanner){
        boolean cartaValida = false;
        int numero = 0, index = -1;
        System.out.println("Digite uma carta para jogar");

        while (!cartaValida) {
            String input = scanner.nextLine();

            try{
                numero = Integer.parseInt(input);
                for (int i = 0; i < cartas.size(); i++) {
                    if (cartas.get(i).getNumero() == numero) {
                        cartaValida = true;
                        index = i;
                        break;
                    }
                }

                if (!cartaValida) {
                    System.out.println("Carta não está na mão");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida");
            }
        }
        return index;
    }

    private static void exibirMenu() {
        System.out.println("==============================");
            System.out.println(" SUPER JOGO DE CARTAS");
            System.out.println("==============================\n");
            System.out.println("OPÇOES:");
            System.out.println(" 1 - Jogar");
            System.out.println(" 2 - Sair");
    }
}