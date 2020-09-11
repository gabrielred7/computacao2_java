
package sistemabancario;

import java.util.Objects;

public class Conta {
    //atributos
    public final static int LIMITE = 100;
    private final long numero;
    private float saldo;
    private String[] historicoOperacoes;
    private int quantItensHistorico;
    private final Correntista correntista;
    private Gerente gerente;
    private Agencia agencia;
            
    //metodos
    public Conta(long numero,  Agencia agencia, Correntista correntista) {
        this.numero = numero;
        this.saldo = 0;
        this.historicoOperacoes = new String[0]; // composição
        this.quantItensHistorico = 0;
        this.correntista = correntista;
        this.gerente = agencia.getGerenteGeral(); // gerente default
        this.agencia = agencia; // agregaçao
    }
            
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    public long getNumero() {
        return numero;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public float getSaldo() {
        return saldo;
    }

    public String[] getHistoricoOperacoes() {
        return historicoOperacoes;
    }
    
    public void receberDepositoEmDinheiro(float valor){
        depositar(valor, "em dinheiro");    
    }
    
    public void sacar(float valor, int senha){
        if (this.saldo - valor < -LIMITE) {
            return;
        }
        this.saldo = this.saldo - valor;
        String novoItem = String.format("Saque: R$.2f", valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
    
    public void efetuarTransferencia(Conta contaDestino, float valor){
        this.saldo = this.saldo - valor;
        contaDestino.depositar(valor, this.getCorrentista().getNome());
        String novoItem = String.format("Transferência efetuada para a conta %d: R$%.2f",
                contaDestino.getNumero(), valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }
    
    public void depositar(float valor, String descricaoOrigem){
        this.saldo += valor;
        String novoItem = String.format("Depósito %s: R$%.2f", descricaoOrigem, valor);
        this.historicoOperacoes[this.quantItensHistorico++] = novoItem;
    }

    @Override
    public int hashCode() {
         return Objects.hash(numero, agencia);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || this.getClass() != obj.getClass()) { return false; }
        Conta conta = (Conta) obj;
        return this.numero == conta.numero && Objects.equals(this.agencia, conta.agencia);
    }
}