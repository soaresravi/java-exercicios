package com.mycompany.mavenproject3;

import java.util.Locale;
import java.util.Scanner;

public class Mavenproject3 {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale. US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many elements will there be in the vector? ");
        int n = sc.nextInt();
        
        int x, pair=0;
        double avg=0;
        double[] numbers = new double[n];
        
        for (x=0; x<numbers.length; x++) {
            System.out.print("Enter the " + (x+1) + "° number: ");
            numbers[x] = sc.nextDouble();
            
            if (numbers[x] % 2 == 0) {
                pair++;
                avg += numbers[x];
            }
        }
        
        avg /= pair;
        
        if (pair > 0) {
            System.out.printf("PEER AVERAGE: %.1f ", avg);
        } else {
            System.out.print("NO PAIR NUMBER");
        }
        
        sc.close();
    }
}
