package application;

import entities.Room;

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();
        
        Room[] room = new Room[10];
        int x, y, roomNumber = 0;
        String name, email;
        
        for (x=1; x<=n; x++) {
            System.out.println("\nRent #" + x);
            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Email: ");
            email = sc.next();
            System.out.print("Room: ");
            roomNumber = sc.nextInt();
            
            room[roomNumber] = new Room(name, email); 
        }
        
        System.out.println("\nBusy rooms: ");
        
        for (x=0; x<10; x++) {
            if (room[x] != null) {
                System.out.println(x + ": " + room[x].getName() + ", " + room[x].getEmail());
            }
        }
        sc.close();
    }
}
