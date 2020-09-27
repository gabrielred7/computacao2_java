
package grafica;

public class ImpressoraMatriz extends Impressora{
    
    public ImpressoraMatriz(String nome) {
        super(nome, "Unica Marca do Mundo Para Matriciais");
    }
    
    @Override
    public void imprimir(String texto){
        System.out.println("Imprimindo do jeito de uma impressora matricial...");
    }
}