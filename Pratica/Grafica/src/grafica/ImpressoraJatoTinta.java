
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
    public void efetuarRecarga(){
         System.out.println("Recarregando tinta da impressora jato de tinta...");
    }
    
    public void executarLimpezaBicos(){
        System.out.println("Executando limpeza dos bicos...");
    }

    @Override
    protected boolean executarImpressaoNoPapel(String texto) {
         if (texto.length() > 2) {
            executarLimpezaBicos();
        }
        super.imprimir(texto);
        System.out.println("Jogando tinta no papel do jeito que uma jato de tinta faz...");
        return true;     //To change body of generated methods, choose Tools | Templates.
    }
}