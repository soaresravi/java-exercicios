package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<String> customers = new ArrayList<>();
        List<Double> salaries = new ArrayList<>();

        String name;
        boolean isValidOption, customerExists;
        double salary;
        int position=-1, option=1;

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Register customer");
            System.out.println("2. View registered customers");
            System.out.println("3. Remove registered customers");
            System.out.println("4. Register customer salary");
            System.out.println("5. View registered salaries");
            System.out.println("6. Remove registered salaries");
            System.out.println("7. Average salary");
            System.out.println("8. Show full list");
            System.out.println("9. Exit");

            isValidOption = false; //é falso, entao obrigatoriamente vai começar o looping e só sair quando eu dizer verdadeiro (quando a opção for válida)

            while (!isValidOption) { //while (isValidOption) significa enquanto for verdadeiro, o operador ! significa nao, entao enquanto nao for verdadeiro...
                System.out.print("\nEnter the option: ");

                while (true) { //enquanto (verdadeiro)
                    try {
                        option = Integer.parseInt(sc.next()); //está lendo o String que o usuário digitar e convertendo pra Int, caso a conversão falhe...
                        break;
                    } catch (NumberFormatException error) { //exceção quando a conversão para número falha
                        System.out.println("Please, only numbers. Try again.\n");
                        System.out.print("Enter the option: ");
                        sc.nextLine(); //quebra de linha
                    }
                    //ou seja, digita string, da pra converter pra um número inteiro? se sim é um número válido, saia do loop, se nao, aviso e digite de novo
                }

                if (option >= 1 && option <= 9) { //é um número válido, mas é uma opção válida?
                    isValidOption = true; //opção válida, saia do loop
                } else {
                    System.out.println("Please, enter a valid option. Try again.");
                }
            }

            sc.nextLine(); //quebra de linha
            
            if (option == 1) {
                isValidOption = false;

                while (!isValidOption) {
                    System.out.print("\nEnter the customer's full name: ");
                    name = sc.nextLine();

                    if (name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) { //matches é usado p verificar string em tal padrão. se letras (uma ou +) de a-z minusculas ou maiusculas seguidas ou nao de outro nome ou + separado por um espaçoseguirem essas condições...
                        if (!customers.contains(name)) { //se ja nao houver o nome na lista de clientes...
                            addCustomers(customers, name);
                            isValidOption = true;
                        } else {
                            System.out.println("The customer " + name + " is already in the list. Try adding a last name.");
                        }
                        
                    } else {
                        System.out.println("Please, type only letters. Try again.");
                    }
                }

            } else if (option == 2) {
                
                if (customers.isEmpty()) { //se a lista de clientes estiver vazia...
                    System.out.println("No customers registered.\n");
                } else {
                    showNamesList(customers);
                }

            } else if (option == 3) {
                isValidOption = false;

                while (!isValidOption) {
                    System.out.print("\nEnter the customer's full name to be removed: ");
                    name = sc.nextLine();
                    
                    if (name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                        customerExists = customers.contains(name);
                        
                        if (customerExists) {
                            removeCustomers(customers, name);
                            isValidOption = true;
                        } else {
                            System.out.println("Customer not found, try again.");
                        }
                        
                    } else {
                          System.out.println("Please, type only letters. Try again.");
                    }
                }

            } else if (option == 4) {
                isValidOption = false;

                while (!isValidOption) {
                    System.out.print("\nEnter the name of the client you want to add the salary to: ");
                    name = sc.nextLine();

                    if (name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {                      
                        position = customers.indexOf(name);

                        if (position != -1) { //isso verifica se o nome existe
                            
                            if (position < salaries.size() && !salaries.get(position).equals(0.0)) { // se o tamanho de salários for maior que a posição e o salário na posição que eu encontrei não for igual a 0 (ou seja, se tem um salário lá)...
                                System.out.printf("Salary already registered for %s. Current salary: $%.2f. Please, try again.%n", name, salaries.get(position));
                            } else {
                                System.out.print("Enter salary to add: $");

                                while (true) {
                                    try {
                                        salary = Double.parseDouble(sc.nextLine()); //mesmo esquema do int
                                        
                                        if (salary <= 0) {
                                            System.out.println("\nPlease, enter a salary greater than 0. Try again.");
                                            System.out.print("Enter salary to add: $");
                                        } else {
                                            break;
                                        }
                                        
                                    } catch (NumberFormatException error) {
                                        System.out.println("\nPlease, enter a valid number. Try again.");
                                        System.out.print("Enter salary to add: $");
                                    }
                                }
                                
                                addSalaries(salaries, position, salary, name);
                                isValidOption = true;
                            }
                            
                        } else {
                            System.out.println("Client not found, try again.");
                        }
                        
                    } else {
                        System.out.println("Please, type only letters. Try again.");
                    }
                }
                
            } else if (option == 5) {
                boolean count = true;
                
                for (Double x : salaries) {
                    if (x != 0.0) {
                        count = false;
                        break;
                    }
                }
                
                if (salaries.isEmpty() || count) {
                    System.out.println("No salaries registered.\n");     
                } else {
                    showSalariesList(salaries);
                }
                
            } else if (option == 6) {
                isValidOption = false;

                while (!isValidOption) {
                    System.out.print("\nEnter the full name of the client you want to remove the salary from: ");
                    name = sc.nextLine();
                    
                    if (name.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                        customerExists = customers.contains(name);

                        if (customerExists) {
                            position = customers.indexOf(name); //a variável position é a posição do 1° aparecimento do nome na lista de clientes
                            
                            if (position < salaries.size()) { //pq pode ser que o usuário queira remover um salário sem ter adicionado
                                removeSalaries(salaries, position);
                                isValidOption = true;
                            } else {
                                System.out.println(name + "'s salary wasn't registered, try to register it or place a client with a registered salary.");
                            }
                            
                        } else {
                            System.out.println("Client not found, try again.");
                        }
                        
                    } else {
                        System.out.println("Please, type only letters. Try again.");
                    }
                }

            } else if (option == 7) {
                
                if (salaries.isEmpty()) {
                    System.out.println("No salaries registered.\n");
                } else {
                    System.out.printf("Average salary is $%.2f%n%n", averageSalaries(salaries));
                }
                
            } else if (option == 8) {           
                
                if (customers.isEmpty() && salaries.isEmpty()) {
                    System.out.println("No customers and salaries registered.\n");
                } else {
                    showFullList(customers, salaries);
                }
                
            } else {
                System.out.print("Closing program...");
                break;
            }
        }
        sc.close();
    }
    
    
    
    public static void addCustomers(List<String> customers, String name) {
        customers.add(name);
        System.out.println("The " + name + " client has been added successfully!\n");
    }
    
    public static void addSalaries(List<Double> salaries, int position, double salary, String name) {
        while (salaries.size() <= position) { //por exemplo, se eu tiver colocando um nome na posição 2 e tiver 0 salários adicionados enquanto a posição for maior ou igual a qtd de salários vai acrescentar salários valendo 0.0 para não ficar vazio e todos terem uma posição
            salaries.add(0.0);
        }

        salaries.set(position, salary); //mudando o salário de 0.0 pro digitado pra mesma posição do nome do cliente

        System.out.printf("The salary of $%.2f for %s was added successfully!%n%n", salary, name);
    }
    
    public static void removeCustomers(List<String> customers, String name) {
        customers.remove(name);
        System.out.println("The " + name + " client has been removed successfully!\n");
    }

    public static void removeSalaries(List<Double> salaries, int position) {
            salaries.set(position, 0.0);
            System.out.println("The salary was removed successfully!\n");
    }

    public static double averageSalaries(List<Double> salaries) {
        double sum=0;
        int count=0;
        
        for (Double salary : salaries) {
            if (salary > 0.0) {
                sum += salary;
                count++; //se nao houver esse contador ele vai dividir pela qtd de pessoas iniciais ja que nao removeu o salário, e sim deixou valendo 0
            }
        }
        
        return sum / count;
    }

    public static void showNamesList(List<String> customers) {
        System.out.println("\nCUSTOMER LIST");

        for (int x=0; x < customers.size(); x++) {
            System.out.println((x+1) + ". " + customers.get(x));
        }

        System.out.println();
    }

    public static void showSalariesList(List<Double> salaries) {       
        System.out.println("\nSALARIES LIST");

        for (int x=0; x < salaries.size(); x++) {            
            System.out.print((x + 1) + ". ");
            
            if (salaries.get(x) > 0.0) {             
                System.out.println(salaries.get(x));     
            } else {
                System.out.println("No registered salary.");
            }
        }
        
        System.out.println();
    }

    public static void showFullList(List<String> customers, List<Double> salaries) {
        System.out.println("\nFULL LIST");

        for (int x=0; x < customers.size(); x++) {
            int y = x;

            System.out.print((x+1) + ". " + customers.get(x) + ". ");

            if (y < salaries.size() && salaries.get(y) > 0.0) { //y < salaries.size() é pq ali ta indo até o tamanho da lista dos clientes e se tiver 6 nomes e o y for o da posição 5 pode não ter salário p mostrar, vai dar erro
                System.out.printf("$%.2f%n", salaries.get(y));
            } else {
                System.out.println("No registered salary.");
            }
        }

        System.out.println();
    }
}
