import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

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
                // case 2:
                //     exibirRanking();
                case 3:
                    System.out.println("Saindo do jogo. Até mais!");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        scanner.close();
    }

    

    public static void Jogar() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Scanner scanner = new Scanner(System.in);

        while (!tabuleiro.getJogadores().get(0).getCartas().isEmpty()) {
            limparTela();

            mostrarTabuleiro(tabuleiro);

            ArrayList<Carta> cartasDaRodada = new ArrayList<Carta>();

            System.out.println();

            for (Jogador jogador : tabuleiro.getJogadores()) {
                System.out.println("Mão do jogador " + jogador.getNome() + ": ");
                System.out.println(jogador.printHand());
                int indexOfCard = escolherCartaJogar(jogador.getCartas(), scanner);
                cartasDaRodada.add(jogador.getCartas().remove(indexOfCard));
            }

            Collections.sort(cartasDaRodada);

            System.out.println("Cartas jogadas essa rodada: ");
            for (Carta carta : cartasDaRodada) {
                System.out.print(carta.getNumero() + " ");
            }
            System.out.println();

            // insertCards(tabuleiro, cartasDaRodada);

            tabuleiro.mostrarEstadoAtual();

            System.out.println("Pressione enter para continuar");

            scanner.nextLine();
        }

        
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    // private static void inserirCarta(ArrayList<ArrayList<Carta>> tabuleiro, ArrayList<Carta> cartasDaRodada) {
    //     for (Carta cartaJogada : cartasDaRodada) {
    //         int indexOfRow = getLinhaMenorCarta(tabuleiro, cartaJogada);
    
    //         if (indexOfRow == -1) {
    //             indexOfRow = getLinhaMaiorCarta(tabuleiro);
    //         }
    
    //         ArrayList<Carta> cartasRemovidasDaLinha = new ArrayList<>();
    //         int pontosTotal = 0;
    
    //         ArrayList<Carta> linha = tabuleiro.get(indexOfRow);
    
    //         for (int i = 0; i < linha.size(); i++) {
    //             if (linha.get(i).getNumero() != 0) {
    //                 cartasRemovidasDaLinha.add(linha.get(i));
    //                 pontosTotal += linha.get(i).getPontos();
    //             }
    
    //             if (linha.get(i).getNumero() == 0) {
    //                 if (i > 0 && linha.get(i - 1).getNumero() > cartaJogada.getNumero()) {
    //                     cartaJogada.getDono().getCartasColetadas().addAll(cartasRemovidasDaLinha);
    //                     cartaJogada.getDono().adicionarPontos(pontosTotal);
    //                     linha.clear();
    //                     linha.add(cartaJogada);
    //                     for (int j = 1; j < 5; j++) {
    //                         linha.add(new Carta());
    //                     }
    //                 } else {
    //                     linha.remove(i);
    //                     linha.add(i, cartaJogada);
    //                 }
    //                 break;
    //             } else if (i == 4) {
    //                 cartaJogada.getDono().getCartasColetadas().addAll(cartasRemovidasDaLinha);
    //                 cartaJogada.getDono().adicionarPontos(pontosTotal);
    //                 linha.clear();
    //                 linha.add(cartaJogada);
    //                 for (int j = 1; j < 5; j++) {
    //                     linha.add(new Carta());
    //                 }
    //                 break;
    //             }
    //         }
    
    //         System.out.println("Carta " + cartaJogada.getNumero() + " inserida na linha " + (indexOfRow + 1));
    //     }
    // }

    private static int getLinhaMaiorCarta(ArrayList<ArrayList<Carta>> tabuleiro){
        int maiorNumero = Integer.MIN_VALUE, indiceLinha = -1;
    
        for (int i = 0; i < tabuleiro.size(); i++) {
            var linha = tabuleiro.get(i);
            for (int j = linha.size() - 1; j >= 0; j--) {
                if(linha.get(j).getNumero() != 0){
                    if (linha.get(j).getNumero() > maiorNumero) {
                        maiorNumero = linha.get(j).getNumero();
                        indiceLinha = i;
                    }
                    break;
                }
            }
        }
    
        return indiceLinha;
    }
    

    private static int getLinhaMenorCarta(ArrayList<ArrayList<Carta>> tabuleiro, Carta cartaJogada){
        int diferencaFinal = Integer.MAX_VALUE, indiceLinha = -1;
    
        for (int i = 0; i < tabuleiro.size(); i++) {
            var linha = tabuleiro.get(i);
            for (int j = linha.size() - 1; j >= 0; j--) {
                if(linha.get(j).getNumero() != 0){
                    if (linha.get(j).getNumero() < cartaJogada.getNumero()) {
                        if (cartaJogada.getNumero() - linha.get(j).getNumero() < diferencaFinal) {
                            diferencaFinal = cartaJogada.getNumero() - linha.get(j).getNumero();
                            indiceLinha = i;
                        }
                    }
                    break;
                }
            }
        }
    
        return indiceLinha;
    }
    
    private static int getIndiceLinhaParaInserir(ArrayList<ArrayList<Carta>> tabuleiro, Carta cartaJogada) {
        // Implemente aqui a lógica para determinar a linha apropriada para inserir a carta
        // Retorne o índice da linha ou -1 se não houver uma linha adequada
        // Exemplo simples: retorna a primeira linha vazia
        for (int i = 0; i < tabuleiro.size(); i++) {
            if (tabuleiro.get(i).get(0).getNumero() == 0) {
                return i;
            }
        }
        return -1;
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
            // System.out.println(" 2 - Ranking");
            System.out.println(" 3 - Sair");
    }


    // private static void exibirRanking() {
    //     Ranking ranking = new Ranking();
    //     ranking.exibir();
    // }
    }