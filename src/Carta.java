public class Carta {
    private int numero;
    private int pontos;

    public Carta(int numero) {
        this.numero = numero;
        this.pontos = calcularPontos();
    }

    public int getNumero() {
        return numero;
    }

    public int getPontos() {
        return pontos;
    }

    private int calcularPontos() {
        int pontosCalculados = 1;  // Pontuação base é 1 ponto

        // Verifica se a carta termina com o dígito 5
        if (numero % 10 == 5) {
            pontosCalculados += 1;
        }

        // Verifica se a carta é múltiplo de 10
        if (numero % 10 == 0) {
            pontosCalculados += 2;
        }

        // Verifica se a carta tem dois dígitos repetidos
        if (temDoisDigitosRepetidos()) {
            pontosCalculados += 4;
        }

        return pontosCalculados;
    }

    private boolean temDoisDigitosRepetidos() {
        String numeroStr = Integer.toString(numero);
        return numeroStr.length() == 2 && numeroStr.charAt(0) == numeroStr.charAt(1);
    }

    public String printCard(){
        return "[Nº " + this.numero + " - p " + this.pontos + "] ";
    }
}