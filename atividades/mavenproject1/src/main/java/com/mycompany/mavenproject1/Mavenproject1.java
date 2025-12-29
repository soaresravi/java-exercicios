package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Digite o valor em formato hexadecimal: ");
            String valor = sc.next();
            
            String[] vetor = valor.split("");
            
            System.out.print("Valor convertido: ");
            
            for (int x=0; x<vetor.length; x++) {
                
                switch (vetor[x]) {
                    case "A":
                        vetor[x] = vetor[x].replace("A", "10");
                        break;
                    case "B":
                        vetor[x] = vetor[x].replace("B", "11");
                        break;
                    case "C":
                        vetor[x] = vetor[x].replace("C", "12");
                        break;
                    case "D":
                        vetor[x] = vetor[x].replace("D", "13");
                        break;
                    case "E":
                        vetor[x] = vetor[x].replace("E", "14");
                        break;
                    case "F":
                        vetor[x] = vetor[x].replace("F", "15");
                        break;
                }
                
                System.out.print(vetor[x]);
            }  
            System.out.print("\n");
        }
    }
}