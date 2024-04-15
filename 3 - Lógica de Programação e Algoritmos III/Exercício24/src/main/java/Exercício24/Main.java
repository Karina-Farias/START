package Exercício24;

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
    
         Scanner leitor = new Scanner(System.in);
        
        char desejaContinuar = 'S';
        
        while(desejaContinuar == 'S' || desejaContinuar == 's'){
            
            int numero = leitor.nextInt();
            
            if(numero == 0){
                System.out.println("O Número é Zero");
            } else {
                if(numero > 0) {
                    System.out.println("O Número é Positivo");
                } else {
                    System.out.println("O Número é Negativo");
                }
            }
            
            System.out.println("Deseja continuar? S - Sim / N - Não");
            desejaContinuar = leitor.next().charAt(0);
        }
    }
    
}
