package application;

import entities.People;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale. US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many people will be entered? ");
        int n = sc.nextInt();
        
        int x, age, biggerAge=0;
        String name, biggerName="";
        double grade1, grade2, height, avg=0.0, peopleUnder16=0.0;
        
        People[] people = new People[n];
        double[] finalGrade = new double[n];
        
        for (x=0; x<people.length; x++) {
            System.out.println((x+1) + "st person data: ");
            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Age: ");
            age = sc.nextInt();
            System.out.print("Height: ");
            height = sc.nextDouble();
            System.out.print("\nGrade 1: ");
            grade1 = sc.nextDouble();
            System.out.print("Grade 2: ");
            grade2 = sc.nextDouble();
            System.out.println();
            
            people[x] = new People(name, age, height, grade1, grade2, 0.0);
            
            avg += people[x].getHeight();
            finalGrade[x] = people[x].getGrade1() + people[x].getGrade2();
            finalGrade[x] /= 2;
            
            if (people[x].getAge() > biggerAge) {
                biggerAge = people[x].getAge();
                biggerName = people[x].getName();
            }
            
            if (people[x].getAge() < 16) {
                peopleUnder16++;
            }    
        }
        
        System.out.println("Aprovade students: ");
        
        for (x=0; x<n; x++) {        
            if (finalGrade[x] >= 6.0) {
                System.out.println(people[x].getName());
            }
        }
        
        System.out.println("\nOlder people: " + biggerName);
        System.out.printf("Average height: %.2f%n",  (avg/n));
        
        peopleUnder16 = peopleUnder16 * 100 / n;
        
        System.out.printf("People under 16: %.1f%%%n", peopleUnder16);
         
        for (x=0; x<people.length; x++) {
            if (people[x].getAge() < 16) {
                System.out.println(people[x].getName());
            }
        }
         
        sc.close();
    }
}