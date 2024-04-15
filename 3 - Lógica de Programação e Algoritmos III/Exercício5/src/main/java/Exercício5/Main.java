package Exercício5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String nomeAluno;
        float totalNotas;
        float media;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o Nome do Aluno: ");
        nomeAluno = leitor.next();
        
        System.out.println("Digite a 1° nota do Aluno: ");
        float n1 = leitor.nextFloat();
        
        System.out.println("Digite a 2° nota do Aluno: ");
        float n2 = leitor.nextFloat();
        
        System.out.println("Digite a 3° nota do Aluno: ");
        float n3 = leitor.nextFloat();
        
        totalNotas = n1 + n2 + n3;
        media = totalNotas / 3;
        
        System.out.println("A média do(a) Aluno(a) " + (nomeAluno) + " é " + (media));

    }

}
