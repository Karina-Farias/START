package Exercício15;

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        int numero;
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        numero = leitor.nextInt();
        
        if(numero >= 100 && numero <= 200){
            System.out.println("O Número " + (numero) + "está no intervalo de 100 e 200");
        } else {
            System.out.println("O Número " + (numero) + " não está no intervalo de 100 e 200");
        }
    }
    
}
