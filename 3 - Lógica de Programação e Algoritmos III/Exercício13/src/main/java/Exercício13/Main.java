package Exercício13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numero;
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        numero = leitor.nextInt();
        
        if(numero > 10){
            System.out.println("O Número " + (numero) + " é maior que 10.");
        } else {
            System.out.println("O Número " + (numero) + " não é maior que 10.");
        }
    }
    
}
