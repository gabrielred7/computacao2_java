package grafica;
import java.awt.*;

public class Impressora {
    
    private String nome;
    private String marca;
    
    private float consumoPercentualPorCaracter;

    private int quantCaracteresImpressos;
    private int quantCaracteresImpressosDesdeUltimaRecarga;
    
    public Impressora(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
        this.consumoPercentualPorCaracter = 0.001f;
    }

    public float getConsumoPercentualPorCaracter() {
        return consumoPercentualPorCaracter;
    }

    public void setConsumoPercentualPorCaracter(float consumoPercentualPorCaracter) {
        this.consumoPercentualPorCaracter = consumoPercentualPorCaracter;
    }
   
    public void imprimir(String texto) {
        if (verificarNecessidadeRecarga(texto)){
            recarregar();
        }
        quantCaracteresImpressos = quantCaracteresImpressos + texto.length();
        quantCaracteresImpressosDesdeUltimaRecarga = quantCaracteresImpressosDesdeUltimaRecarga + texto.length();
        System.out.println("Enviando texto para a impressora física...");
    }
    
    private boolean verificarNecessidadeRecarga(String texto){
        System.out.println("Verificando a Necessidade de Reccarga");
        
        float percentualConsumido = 
                quantCaracteresImpressosDesdeUltimaRecarga * consumoPercentualPorCaracter;
        
        float percentualRequerido = 
                texto.length() * quantCaracteresImpressosDesdeUltimaRecarga;
        
        boolean decisao = 
               percentualConsumido + percentualRequerido > 100;
                
        return decisao;
    }
    
    public void recarregar() {
        System.out.println("Recarregando...");

        quantCaracteresImpressosDesdeUltimaRecarga = 0;
    }       
}