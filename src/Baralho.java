import java.util.ArrayList;
import java.util.Collections;

class Baralho {
    private ArrayList<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        inicializarBaralho();
        embaralharCartas();
    }

    public Carta comprarCarta() {
        if (!getCartas().isEmpty()) {
            return getCartas().remove(0);
        } else {
            System.out.println("O baralho está vazio!");
            return null;
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    private void inicializarBaralho() {
        for (int numero = 1; numero <= 109; numero++) {
            cartas.add(new Carta(numero));
        }
    }

    private void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    
    
}