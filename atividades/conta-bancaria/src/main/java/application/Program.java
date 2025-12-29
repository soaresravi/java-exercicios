package application;

import entities.Holder;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale. US);
        Scanner sc = new Scanner(System.in);
        
        Holder holder; //declarado aqui pq tem dois construtores que precisam ser colocados no if // else
        
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine(); // quando houver nextAlguma coisa vai comer minha linha
        System.out.print("Enter the account holder: ");
        String accountHolder = sc.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        char answer = sc.next().charAt(0);
        
        if (answer == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            
            holder = new Holder(accountNumber, accountHolder, initialDeposit); //deposito inicial é opcional
            
        } else {
            holder = new Holder(accountNumber, accountHolder);
        }
        
        holder.setAccountHolder("Ravi Soares");
        System.out.println("\nUpdate account holder: " + holder.getAccountHolder());
        
        System.out.println("\nAccount data: " + holder);
        
        System.out.print("\nEnter a deposit value: ");
        double depositValue = sc.nextDouble();
        holder.deposit(depositValue);
        
        System.out.println("Update data: " + holder);
        
        System.out.print("\nEnter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        holder.withdraw(withdrawValue);
        
        System.out.print("Update data: " + holder);
        
        sc.close();
    }
}
