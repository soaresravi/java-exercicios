package com.mycompany.calculadora.simples;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraSimples {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale. US);
        
        int opcao;
        double num1, num2;
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Digite um número: ");
            num1 = sc.nextDouble();
            System.out.print("Digite outro número: ");
            num2 = sc.nextDouble();
            
            System.out.println("\n1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Sair");
            
            System.out.print("\nDigite a opção: ");
            opcao = sc.nextInt();
            
            if (opcao == 1) {
                somar(num1, num2);
            } else if (opcao == 2) {
                subtrair(num1, num2);
            } else if (opcao == 3) {
                multiplicar(num1, num2);
            } else if (opcao == 4) {
                dividir(num1, num2);
            } else if (opcao == 5) {
                break;
            } else {
                System.out.print("Opção inválida, digite novamente\n");
            }
        }
        
        sc.close();
        
    }
    
    public static double somar (double num1, double num2) {
        
        double resultado = num1 + num2;
        System.out.println("A soma entre " + num1 + " e " + num2 + " é " + resultado + "\n");
        
        return resultado;
    }
    
    public static double subtrair (double num1, double num2) {
        
        double resultado = num1 - num2;
        System.out.println("A subtração entre " + num1 + " e " + num2 + " é " + resultado + "\n");
        
        return resultado;
    }
    
    public static double multiplicar (double num1, double num2) {
        
        double resultado = num1 * num2;
        System.out.println("A multiplicação entre " + num1 + " e " + num2 + " é " + resultado + "\n");
        
        return resultado;
    }
    
    public static double dividir (double num1, double num2) {
        
        double resultado = num1 / num2;
        System.out.printf("A divisão entre %.1f e %.1f é %.2f%n%n", num1, num2, resultado);
        
        return resultado;
    }
}
