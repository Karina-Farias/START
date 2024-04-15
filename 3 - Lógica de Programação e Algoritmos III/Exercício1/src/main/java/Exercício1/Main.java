package Exercício1;

import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {
       
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o Primeiro Número: ");
        int n1 = leitor.nextInt();
        
        System.out.println("Digite o Segundo Número: ");
        int n2 = leitor.nextInt();
        
        int totalSoma;
        totalSoma = n1 + n2;
        
        System.out.println("O resultado das somas é: " + (totalSoma));
    }
    
}
