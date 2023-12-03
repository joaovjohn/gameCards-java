import java.util.ArrayList;

public class Jogador {
    private String nome;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int pontos;
    private ArrayList<Carta> compradas;


    public Jogador(String nome, Baralho baralho) {
        this.nome = nome;
        for (int i = 0; i < 12; i++) {
            cartas.add(baralho.comprarCarta());
        }
        this.pontos = 0;
        this.compradas = new ArrayList<Carta>(); // monte de cartas que comprou 
    }

    public String getNome() {
        return nome;
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

    public ArrayList<Carta> getCompradas() {
        return compradas;
    }

    public void setCompradas(ArrayList<Carta> compradas) {
        this.compradas = compradas;
    }
}