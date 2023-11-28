import java.util.Collections;
import java.util.Stack;

class Baralho {
    private Stack<Carta> pilhaDeCartas;

    public Baralho() {
        pilhaDeCartas = new Stack<>();
        inicializarBaralho();
        embaralharCartas();
    }

    public void inicializarBaralho() {
        for (int numero = 1; numero <= 109; numero++) {
            pilhaDeCartas.push(new Carta(numero));
        }
        listarCompacto();

        
    }

    public void embaralharCartas() {
        Collections.shuffle(pilhaDeCartas);
    }

    // public Carta comprarCarta() {
    //     if (!pilhaDeCartas.isEmpty()) {
    //         return pilhaDeCartas.pop();
    //     } else {
    //         System.out.println("O baralho está vazio!");
    //         return null;
    //     }
    // }
    public int getSize() {
        return pilhaDeCartas.size();
    }

    // public void listarCompacto() { // Só pra debug
    //     Carta carta;
    //     for (int i = 0; i < pilhaDeCartas.size(); i++) {
    //         carta = pilhaDeCartas.get(i);
    //         int baralho = carta.getNumero();

    //     }
    //     System.out.println("Carta: " + carta);
    // }
    
}