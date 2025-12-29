package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale. US);
        Scanner sc = new Scanner(System.in);
        
       
        System.out.println("Enter the product data: ");
        System.out.print("Name: ");
        String name = sc.next(); // aqui vai o nome da variavel nao entidade e depois os atributos dela
        System.out.print("Price: ");
        double price = sc.nextDouble();
        
        Product product = new Product(name, price); // Triangle x = new Triangle()
        
        product.setName("Computer");
        System.out.println("\nUpdate name: " + product.getName());
        product.setPrice(1200);
        System.out.println("Update price: " + product.getPrice());
        
        System.out.println("\nProduct data: " + product);            
        
        System.out.print("\nEnter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.AddProducts(quantity);
        
        System.out.println("\nUpdated data: " + product);
        
        System.out.print("\nEnter the number of products to be removed from stock: ");
        quantity = sc.nextInt();
        product.RemoveProducts(quantity);
        
        System.out.print("\nUpdated data: " + product);
        
        sc.close();
    }
}
