
package album;

public class Album {
    
    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
    private int totalFigurinhas;
    private int totalPacotinhosRecebidos;
    private int quantFigurinhasPorPacotinho;
    private int quantFigurinhasColadas;
    private int quantFigurinhasRepetidas;
    private int quantFigurinhasFaltando;

    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
    }

    public int getTotalPacotinhosRecebidos() {
        return totalPacotinhosRecebidos;
    }

    public int getQuantFigurinhasColadas() {
        return quantFigurinhasColadas;
    }

    public int getQuantFigurinhasRepetidas() {
        return quantFigurinhasRepetidas;
    }

    public int getQuantFigurinhasFaltando() {
        return quantFigurinhasFaltando;
    }
    
    public void receberNovoPacotinho(Figurinha[] pacotinho){
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            // faça alguma coisa com essa figurinha recebida
            // (uma boa ideia é armazená-la em algum tipo de estrutura)
        }
    }
     /**
     * Metodo encomendarFigurinhaRestantes
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes(){} // (será preciso validar a regra dos 10%)
    public boolean possuiFigurinhaColada(int posicao){return false;}
    public boolean possuiFigurinhaColada(Figurinha figurinha){return false;} //overload
    public boolean possuiFigurinhaRepetida(int figurinha){return false;}
    public boolean possuiFigurinhaRepetida(Figurinha figurinha){return false;} //overload
    
    
    
    }
