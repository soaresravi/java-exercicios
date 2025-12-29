package com.mycompany.calc_media;
import java.util.Scanner;

public class Calc_media {

    public static void main(String[] args) {    
        
        int x;
        String palavra = "batata arroz maçã cheescake sonho brownie";
        String[] palavras = palavra.split(" ");
        
        System.out.println("Palavras que começam com B: ");
        
        for (x=0; x<=5; x++) {
            if (palavras[x].indexOf("b") == 0) {
                System.out.println(palavras[x]);
            }
        }
    }
}
