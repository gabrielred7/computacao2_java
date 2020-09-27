
package grafica;

public class ImpressoraJatoTinta extends Impressora {
    private boolean colorida;

    public ImpressoraJatoTinta(String nome, String marca, boolean colorida) {
        super(nome, marca);
        this.colorida = colorida;
    }

    public boolean isColorida() {
        return colorida;
    }

    public void setColorida(boolean colorida) {
        this.colorida = colorida;
    }
    
    @Override
    public void imprimir(String texto){
        if (texto.length() > 2) {
            executarLimpezaBicos();
        }
        super.imprimir(texto);
        System.out.println("Imprimindo do jeito de uma impressora jato de tinta...");
    }
    
    public void executarLimpezaBicos(){
        System.out.println("Executando limpeza dos bicos...");
    }
}