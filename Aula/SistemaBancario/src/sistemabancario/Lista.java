
package sistemabancario;


public class Lista {
    private Object[] itens;
    private int quantItens;
    
    public Lista(){
        this.itens = new Object[10];
        quantItens = 0;
    }
 
     /**
     * Adiciona um item novo na primeira posição vaga da lista.
     * @return 
     */
    
    // Unico metodo que pode mudar dependendo do objeto
    // Só ele substitui a funcão do 4 'quant_'s originais
    public int getTamanho() {
        return quantItens;
    }
    
    /**
     * Adiciona um item novo na primeira posição vaga da lista.
     * @param item O novo item.
     */
    
    public void adicionarItem(Object item) {
        // em caso de array "cheio", preciso aumentar o espaço do array
        if (this.quantItens == this.itens.length) {
            redimensionarArray();
        }
        // depois de array aumentado adciciona no array
        this.itens[this.quantItens++] = item;
    }
    
    /**
     * Retorna o item da posição desejada.
     *
     * @param posicao a posição desejada
     * @return o item desejado, caso exista; null, se a posição informada não existir na lista
     */
    public Object obterItem(int posicao) {
        if (posicao >= this.quantItens || posicao < 0) {
            return null;  // como combinado
        }
        return this.itens[posicao];
    }

    private void redimensionarArray() {
        // crio um novo array
        Object[] novoArray = new Object[this.itens.length * 2];
        // copio o array antigo para o array novo
        for (int i = 0; i < this.itens.length; i++) {
            novoArray[i] = this.itens[i];
        }
        // reaponto o atributo this.itens para a nova região de memória alocada
        this.itens = novoArray;
    }

}