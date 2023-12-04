import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Tabuleiro {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Baralho baralho;
    private ArrayList<LinkedList<Carta>> tabuleiro;

    public Tabuleiro() {
        configurarJogo();
    }
    
    public ArrayList<LinkedList<Carta>> getTabuleiro() {
        return tabuleiro;
    }

    public void mostrarEstadoAtual() {
        System.out.println("\nEstado Atual do Tabuleiro:");
        for (Jogador jogador : jogadores) {
            mostrarTudoJogador(jogador);
        }
    }

    public static void mostrarTabuleiro(ArrayList<LinkedList<Carta>> tabuleiro) {
        for (LinkedList<Carta> linha : tabuleiro) {
            for (Carta carta : linha) {
                System.out.printf("[%3d] ", carta.getNumero());
            }

            for (int i = 0; i < 5 - linha.size(); i++) {
                System.out.print("[   ] ");
            }
            System.out.println("{   }");
        }
        System.out.println();
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
   
    private static void mostrarTudoJogador(Jogador jogador) { // utilizado para mostrar estado atual do jogo
        System.out.println("\nJogador: " + jogador.getNome());
        System.out.println("Cartas do jogador: ");
        if (!jogador.getCartas().isEmpty()) {
            for (Carta carta : jogador.getCartas()) {
                System.out.print(carta.printCard());
            }
        } else {
            System.out.println("Sem cartas na mão vazia!");
        }

        System.out.print("\nCartas compradas: ");
        if (!jogador.getCompradas().isEmpty()) {
            for (Carta comprada : jogador.getCompradas()) {
                System.out.printf("|%d", comprada.getNumero());
            }
        } else {
            System.out.println("Nenhuma carta comprada!");
        }
        System.out.println("Pontos: " + jogador.getPontos());
    }

    private void configurarJogo() {
        baralho = new Baralho();
        Scanner jogador = new Scanner(System.in);
        int numeroJogadores;

        do {
            System.out.println("------------------------------");
            System.out.print("Digite o número de jogadores (3 à 6): ");
            numeroJogadores = jogador.nextInt();

            if (numeroJogadores < 3 || numeroJogadores > 6) {
                System.out.println("Número de jogadores inválido!");
            } else {
                criarJogadores(numeroJogadores, jogador);
            }
        } while (numeroJogadores < 3 || numeroJogadores > 6);

        criaTabuleiro();
    }

    private void criarJogadores(int numeroJogadores, Scanner jogador) {
        System.out.println("Digite os nomes:");
        for (int i = 0; i < numeroJogadores; i++) {
            System.out.printf("JOGADOR [%d] -> ", (i + 1));
            String nome = jogador.next();
            jogadores.add(new Jogador(nome, baralho));
        }
    }

    private void criaTabuleiro() {
        tabuleiro = new ArrayList<LinkedList<Carta>>();
        for (int i = 0; i < 5; i++) {
            tabuleiro.add(new LinkedList<Carta>());
            tabuleiro.get(i).addLast(baralho.comprarCarta());
        }
        System.err.println();
    }
}