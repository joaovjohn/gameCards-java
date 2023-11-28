// import java.util.Scanner;
// import java.util.ArrayList;

// public class Jogadores {

//     private ArrayList<Jogador> jogadores;

//     public Jogadores() {
        
//         Scanner in = new Scanner(System.in);
//         int numero;
//         String nome;

//         jogadores = new ArrayList<>();

//         do {
//             System.out.println("------------------------------");
//             System.out.print("Digite o número de jogadores (3 à 6): ");

//             numero = in.nextInt();

//             if (numero < 3 || numero > 6) {
//                 System.out.println("Número de jogadores inválido!");
//             } else {
//                 System.out.println("Digite os nomes:");
//                 for (int i = 0; i < numero; i++) {
//                     System.out.printf("JOGADOR [%d] -> ", (i + 1));
//                     nome = in.next();
//                     jogadores.add(new Jogador(nome, i + 1));
//                 }
//             }
//         } while (numero < 3 || numero > 6);
//     }

//     public Jogador getJogadorByIndex(int index) {
//         return jogadores.get(index);
//     }

//     public int getSize() {
//         return this.jogadores.size();
//     }

//     public void exibeJogadores() { // Só pra DEBUG
//         Jogador jogador;
//         Baralho cartas;

//         System.out.println("\n------------------------------");
//         System.out.println("LISTA JOGADORES:");

//         for (int i = 0; i < jogadores.size(); i++) {
//             jogador = jogadores.get(i);
//             cartas = jogador.getCartas();
//             System.out.println("------------------------------");
//             System.out.println(jogador.toString());
//             if (cartas.getSize() > 0) {
//                 System.out.println("Cartas:");
//                 jogadores.get(i).getCartas().listarCompacto();
//             }

//         }
//     }


//     // public void darCartas(Baralho mesa) {
//     //     int aux = 0;
//     //     int num = mesa.getSize();
//     //     Carta carta;

//     //     for (int i = 0; i < num; i++) {
//     //         carta = mesa.getCartaByIndex(0);
//     //         mesa.Excluir(carta);
//     //         jogadores.get(aux).adicionaCarta(carta);

//     //         aux++;
//     //         if (aux >= jogadores.size()) aux = 0;
//     //     }
//     // }

//     // public void recolheCartas(Jogador jogador) {
//     //     Jogador aux;
//     //     Carta carta;

//     //     for (int i = 0; i < jogadores.size(); i++) {
//     //         aux = jogadores.get(i);

//     //         if (aux != jogador) {
//     //             carta = aux.getCartaByIndex(0);
//     //             aux.excluiCarta(carta);
//     //             jogador.adicionaCarta(carta);
//     //         }
//     //     }
//     // }

// }