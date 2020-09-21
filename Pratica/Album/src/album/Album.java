
package album;

import java.util.ArrayList;

public class Album {
    
    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%
    private int totalFigurinhasDoAlbumCompleto;
    private int totalPacotinhosRecebidos = 0;
    private int quantFigurinhasPorPacotinho;
    private int quantFigurinhasColadas;
    
    private ArrayList<Figurinha> figurinhasColadas;
    private ArrayList<Figurinha> figurinhasRepetidas;
    
    public Album(int totalFigurinhasDoAlbumCompleto, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhasDoAlbumCompleto = totalFigurinhasDoAlbumCompleto;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        this.totalPacotinhosRecebidos = 0;
        this.quantFigurinhasColadas = 0;
        
        this.figurinhasColadas = new ArrayList<>();
        this.figurinhasRepetidas = new ArrayList<>();
    }

    public int getTotalFigurinhasDoAlbumCompleto() {
        return totalFigurinhasDoAlbumCompleto;
    }

    public int getQuantFigurinhasPorPacotinho() {
        return quantFigurinhasPorPacotinho;
    }
    
    public int getTotalPacotinhoRecebidos(){
        return this.totalPacotinhosRecebidos;
    }

    public int getQuantFigurinhasColadas() {
        return this.figurinhasColadas.size();
    }

    public int getQuantFigurinhasRepetidas() {
        return this.figurinhasRepetidas.size();
    }
   
   public int getQuantFigurinhasFaltando(){
       return this.totalFigurinhasDoAlbumCompleto - getQuantFigurinhasColadas();
   } 
    
    public void receberNovoPacotinho(Figurinha[] pacotinho){
        if (pacotinho.length != this.quantFigurinhasPorPacotinho) {
            return; // nao faz nada
        }
        this.totalPacotinhosRecebidos++;
        
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            if (possuiFigurinhaColada(figurinha)) {
                this.figurinhasRepetidas.add(figurinha);
            } else {
                this.figurinhasColadas.add(figurinha);
            }            
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
    public void encomendarFigurinhasRestantes(){
        
        //valida regra dos 10%
        if (getQuantFigurinhasColadas() < this.totalFigurinhasDoAlbumCompleto * PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR) {
            return;
        }
        
        for (int i = 1; i <= this.totalFigurinhasDoAlbumCompleto; i++) {
            if (!possuiFigurinhaColada(i)) {
                Figurinha figurinha = new Figurinha(i,  "http://urlDaFigurinha" + i + ".jpg");
                this.figurinhasColadas.add(figurinha);
            }
        }
    } // (será preciso validar a regra dos 10%)
    public boolean possuiFigurinhaColada(int posicao){
        for (Figurinha figurinha : this.figurinhasColadas) {
            if (figurinha.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }
    public boolean possuiFigurinhaColada(Figurinha figurinha){return false;} //overload
    
    public boolean possuiFigurinhaRepetida(int posicao){
         for (Figurinha figurinha : this.figurinhasRepetidas) {
            if (figurinha.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }
    public boolean possuiFigurinhaRepetida(Figurinha figurinha){return false;} //overload

    }