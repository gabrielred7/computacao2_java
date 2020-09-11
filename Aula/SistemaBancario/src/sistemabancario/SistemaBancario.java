
package sistemabancario;

public class SistemaBancario {

    public static void main(String[] args) {
        Correntista cor1 = new Correntista("Carla Costa", 11111);
        Correntista cor2 = new Correntista("João da Silva", 11111);
        
        Agencia agencia = new Agencia();
        
        Conta cont1 = new Conta(1234, agencia, cor1);
        Conta cont1Replica = new Conta(1234, agencia, cor1);
        
        Conta cont2 = new Conta(1234, agencia, cor1);
        
        System.out.println(cont1 == cont2);
        System.out.println(cont1 == cont1);
        
        System.out.println(cont1 == cont1Replica);
        System.out.println(cont1.equals(cont1Replica));
        
        System.out.println("-------------");
        String x = new String("labcd2");
        String y = new String("labcd2");
        
        System.out.println(x == y);
        System.out.println(x.equals(y));

        Conta cont3 = cont1;
        System.out.println("cont3 == cont1 ? " + (cont3 == cont1));    }
}