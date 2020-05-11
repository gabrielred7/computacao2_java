package helloworld2;

import java.util.Scanner;

public class HelloWorld2 {
    
    public static void imprimirDivisores(int numero) {
        for (int divisor = 1; divisor <= numero; divisor++) {
            if (numero % divisor == 0)
                System.out.println(divisor);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Scanner sc = new Scanner(System.in);
        String linha = sc.nextLine();

        int tamanho = linha.length();

        System.out.println("Voce digitou: " + linha);
        System.out.printf("Voce digitou: %s (contem %d caracteres)\n", linha, tamanho);
        
        System.out.println("Digite um numero para exibir seus divisores:");
        int divi = sc.nextInt();
        imprimirDivisores(divi);
    }
}