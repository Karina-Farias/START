package Exercício2;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        int totalSoma;
        int totalSubtracao;
        int totalMultiplicacao;
        int totalDivisao;
       
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o Primeiro Número: ");
        int n1 = leitor.nextInt();
        
        System.out.println("Digite o Segundo Número: ");
        int n2 = leitor.nextInt();
        
        totalSoma = n1 + n2;
        System.out.println("O resultado da Soma é: " + (totalSoma));
        
        totalSubtracao = n1 - n2;
        System.out.println("O resultado da Subtração é: " + (totalSubtracao));
        
        totalMultiplicacao = n1 * n2;
        System.out.println("O resultado da Multiplicação é: " + (totalMultiplicacao));
        
        totalDivisao = n1 / n2;
        System.out.println("O resultado da Divisão é: " + (totalDivisao));
    }
    
}
