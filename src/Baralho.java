import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Baralho {
    private ArrayList<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        inicializarBaralho();
        embaralharCartas();
    }

    public void inicializarBaralho() {
        for (int numero = 1; numero <= 109; numero++) {
            cartas.add(new Carta(numero));
        }
    }

    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    public void listar() {
        for (Carta carta : cartas) {
            System.out.println(carta.printCard());
        }
    }

    public Carta comprarCarta() {
        if (!getCartas().isEmpty()) {
            return getCartas().remove(0);
        } else {
            System.out.println("O baralho está vazio!");
            return null;
        }
    }

    public int getSizeBaralho() {
        return cartas.size();
    }

    public ArrayList<Carta> getPilhaDeCartas() {
        return cartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    //utilizado para debugar
    // public static void mostrarBaralho(Baralho baralho) {
    //     Stack<Carta> copiaDoBaralho = new Stack<>();
    //     copiaDoBaralho.addAll(baralho.getPilhaDeCartas());

    //     System.out.println("Cartas no baralho:");
    //     while (!copiaDoBaralho.isEmpty()) {
    //         Carta carta = copiaDoBaralho.pop();
    //         System.out.println(carta.printCard());
    //     }
    // }
}