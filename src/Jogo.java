import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

            System.out.println();

            for (Jogador jogador : tabuleiro.getJogadores()) {
                System.out.println("Mão do jogador " + jogador.getNome() + ": ");
                System.out.println(jogador.printHand());
                int index = escolherCartaJogar(jogador.getCartas(), scanner);
                jogador.setCartaJogada(jogador.getCartas().get(index));
                jogador.getCartas().remove(index);
            }

            Collections.sort(tabuleiro.getJogadores());
            System.out.println();

            System.out.println("Cartas jogadas essa rodada: ");
            for (Jogador j : tabuleiro.getJogadores()) {
                System.out.print(j.getCartaJogada().getNumero() + " ");
            }

            System.out.println();

            for(Jogador j : tabuleiro.getJogadores()){
                inserirCartas(tabuleiro.getTabuleiro(), j);
            }

            tabuleiro.mostrarEstadoAtual();

            System.out.println("Pressione enter para continuar");

            scanner.nextLine();
        }

        ganhador(tabuleiro.getJogadores());
    }

    private static void ganhador(ArrayList<Jogador> jogadores) {
        int menor = 0;
        Jogador ganhador = null;
        for (Jogador jogador : jogadores) {
            if(jogador.getPontos() < menor){
                menor = jogador.getPontos();
                ganhador = jogador;
            }
            if(ganhador == null){
                System.out.println("Empate");
                return;
            }
        }
        System.out.println("O ganhador é " + ganhador.getNome() + " com " + ganhador.getPontos() + " pontos");
    }

    private static void inserirCartas(ArrayList<LinkedList<Carta>> tabuleiro, Jogador jogador) {
        int anterior = 0;
        int index = -1;
        int maior = 0;
        int indexMaior = -1;
        Carta cartaAtual = jogador.getCartaJogada();
        for (int i = 0; i < tabuleiro.size(); i++) {
            LinkedList<Carta> linha = tabuleiro.get(i);
            if(linha.getLast().getNumero() > anterior && linha.getLast().getNumero() < cartaAtual.getNumero()){
                anterior = linha.getLast().getNumero();
                index = i;
            } else if(linha.getLast().getNumero() > maior){
                maior = linha.getLast().getNumero();
                indexMaior = i;
            }
        }

        if(index != -1){
            if(tabuleiro.get(index).size() == 5){
                jogador.setCompradas(tabuleiro.get(index));
                for(Carta c : jogador.getCompradas()){
                    jogador.setPontos(jogador.getPontos()+c.getPontos());
                }
                tabuleiro.get(index).clear();
            }
            tabuleiro.get(index).addLast(cartaAtual);
        } else {
            jogador.setCompradas(tabuleiro.get(indexMaior));
            for(Carta c : jogador.getCompradas()){
                    jogador.setPontos(jogador.getPontos()+c.getPontos());
                }
            tabuleiro.get(indexMaior).clear();
            tabuleiro.get(indexMaior).addLast(cartaAtual);
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