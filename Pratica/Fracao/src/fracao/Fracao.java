
package fracao;

public class Fracao {
    
    private int numerador;
    private int denominador;
    private boolean positiva;
    
    /**
     * Construtor. Regras:
     * O sinal da fração é passado no parâmetro específico.
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param positiva se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean positiva) {
        // ToDo IMPLEMENT ME!!!
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean isPositiva() {
        return positiva;
    }
    
    public double getValorNumerico() {
        return 0;  // ToDo IMPLEMENT ME!!!
    }
    
    public Fracao getFracaoGeratriz() {
        return null;  // ToDo IMPLEMENT ME!!!
    }
}