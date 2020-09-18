
package album;

import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
        Random random = new Random();
        
        int[] numeros = new int[20]; //arrays de 20 inteiros
        for (int i = 0; i < 20; i++) {
            numeros[i] = random.nextInt();
        }
        for (int x : numeros) {
            System.out.println(x);
        }
    }
}