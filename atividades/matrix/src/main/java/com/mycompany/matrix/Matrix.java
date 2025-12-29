package com.mycompany.matrix;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        
        for (int line=0; line < matrix.length; line++) {
            for (int column=0; column < matrix[line].length; column++) {
                matrix[line][column] = sc.nextInt();
            }
        }
        
        int x = sc.nextInt();
        
        System.out.println();
        
        
        for (int line=0; line < matrix.length; line++) {
            for (int column=0; column < matrix[line].length; column++) {
                
                if (matrix[line][column] == x) {
                    System.out.println("Position " + line + ", " + column + ":");
                   
                    if (column > 0) { //pq se estiver na coluna 0, nao importa a linha nao vai ter esquerda
                        System.out.println("Left: " + matrix[line][column-1]);
                    }
                    
                    if (column < n-1) { //column < matrix[line].length-1
                        System.out.println("Right: " + matrix[line][column+1]);
                    }
                    
                    if (line > 0) {
                        System.out.println("Up: " + matrix[line-1][column]);
                    }
                    
                    if (line < m-1) { //line < matrix.length-1
                        System.out.println("Down: " + matrix[line+1][column]);
                    }
                    
                }
            }
        }
        
        sc.close();
    }
}
