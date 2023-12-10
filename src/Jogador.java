import java.util.ArrayList;
import java.util.LinkedList;

public class Jogador implements Comparable<Jogador> {
    private String nome;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int pontos;
    private LinkedList<Carta> compradas;
    private Carta cartaJogada;
    


    public Jogador(String nome, Baralho baralho) {
        this.nome = nome;
        for (int i = 0; i < 12; i++) {
            cartas.add(baralho.comprarCarta());
        }
        this.pontos = 0;
        this.compradas = new LinkedList<Carta>(); // monte de cartas que comprou 
    }

    public String getNome() {
        return nome;
    }

    public Carta getCartaJogada() {
        return cartaJogada;
    }

    public void setCartaJogada(Carta cartaJogada) {
        this.cartaJogada = cartaJogada;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Carta removerCarta() {
        return cartas.remove(0);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public LinkedList<Carta> getCompradas() {
        return compradas;
    }

    public String printHand(){
        String res = "";
        for (Carta carta : cartas) {
            res += carta.printCard();
        }
        return res;
    }

    public void setCompradas(LinkedList<Carta> compradas) {
        this.compradas.addAll(compradas);
    }

    @Override
    public int compareTo(Jogador o) {
        return this.getCartaJogada().getNumero() - o.getCartaJogada().getNumero();
    }
}