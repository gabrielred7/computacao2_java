
package sistemabancario;

public class SistemaBancario {

    public static void main(String[] args) {
        Correntista cor1 = new Correntista("Carla Costa", 11111);
        Correntista cor2 = new Correntista("João da Silva", 11111);
        
        Agencia agencia = new Agencia();
        
        Conta cont1 = new Conta(1234, agencia, cor1);        
        Conta cont2 = new Conta(5679, agencia, cor2);
        
        cont1.depositar(400, "dinheiro");
        cont2.depositar(200, "dinheiro");    
        
        Conta.facaAlgumaCoisa(333);
    }
}