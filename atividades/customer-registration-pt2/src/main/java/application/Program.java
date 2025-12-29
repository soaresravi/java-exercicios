package application;

import entities.Customers;

import java.util.ArrayList;
import java.util.List;

import java.util.Locale;
import java.util.Scanner;

import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n;
        boolean isValid, salaryRemoved, customerExists = false;
        double highestSalary = 0.0, sum=0.0;
        List<Customers> customers = new ArrayList<>();

        System.out.print("How many employees will be registered? ");

        while (true) {
            try {
                n = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException error) {
                System.out.println("Please, enter a valid number. Try again.\n");
                System.out.print("How many employees will be registered? ");
                sc.nextLine();
            }
        }
        
        sc.nextLine(); //quebra de linha e ta aqui pq se for dentro do looping vai a cada novo funcionário e nao precisa

        for (int x=0; x<n; x++) {
            //se eu declarar o cust lá em cima não adiciona os funcionários
            Customers cust = new Customers(); //se eu fazer um customers com construtor nome e salário e declarar lá em baixo eu vou ter que declarar name = null lá em cima, que é justamente o objetivo do construtor não ter
            isValid = false; //se eu declarar false la em cima ele pula o nome no 2° funcionário
            
            System.out.println("\nEmployee #" + (x+1));

            while (!isValid) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                cust.setName(name); //como o elemento está privado eu preciso usar o set pra mudar o nome de null pro digitado

                if (cust.getName().matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                    
                    for (Customers c : customers) {
                        if (c.getName().equalsIgnoreCase(name)) { //equalsIgnoreCase serve para ele nao diferenciar minusculas de maiusculas
                            customerExists = true; //se o nome do funcionário na posição x for igual ao nome digitado independente de letras maiusculas ou minusculas...
                        }
                    }
                    
                    if (customerExists) {
                        System.out.println("The customer " + cust.getName() + " is already in the list. Try adding a last name.\n");
                    } else {
                        customers.add(cust);
                        isValid = true;
                    }

                } else {
                    System.out.println("Please, type only letters. Try again.\n");
                }
            }

            System.out.print("Salary: $");
            while (true) {
                try {
                    Double salary = Double.parseDouble(sc.nextLine());
                    cust.setSalary(salary);
                    
                    if (cust.getSalary() <= 0) {
                        System.out.println("\nPlease, enter a salary greater than 0. Try again.");
                        System.out.print("Salary: $");
                    } else {
                        break;
                    }

                } catch (NumberFormatException error) {
                    System.out.println("\nPlease, enter a valid salary. Try again.");
                    System.out.print("Salary: $");
                }
            }
        }
        
        System.out.println();
        System.out.println("Full list.");
        
        for (int x=0; x < customers.size(); x++) {
            System.out.println((x+1) + ". " + customers.get(x));
        }
        
        System.out.println("\n---------------------------\n");
        System.out.println("Updated list: all employees called 'Maria'.\n");
        
        List<Customers> employeesMaria = customers.stream().filter(x -> x.getName().toLowerCase().startsWith("maria")).collect(Collectors.toList());
        // crio uma lista do tipo Customers de todos os funcionários que chamam maria. transformo pra stream, filtro para cada elemento da lista ser x (como se fosse o for each) e ele pegar o 1° nome do funcionário da posição x, transformar td em minusculo e ver se chama maria independente do sobrenome, ao fim chamar o coletor p coletar em lista a expressão lambda
        
        if (employeesMaria.isEmpty()) { //se nao houver marias na lista
            System.out.println("No employee named 'Maria'.");
        } else {
            for (Customers e : employeesMaria) {
                System.out.println(e); //pois tem o toString
            }
            
            int position = customers.indexOf(customers.stream().filter(x -> x.getName().toLowerCase().startsWith("maria")).findFirst().orElse(null));
            // variavel posição: primeiro aparecimento da lista cutomers. transformo em stream, filtro igual o anterior, encontro o primeiro ou retorno nulo se nao houver
            System.out.println("\nPosition of the first 'Maria': " + (position+1)); //como ta dentro do else se encontrar nao preciso verificar se a posição deu nulo
        }
        
        System.out.println("\n---------------------------\n");
        System.out.println("Updated list: employees who earn more than $4230.\n");
        
        List<Customers> employeesHighSalaries = customers.stream().filter(x -> x.getSalary() > 4320).collect(Collectors.toList()); // o collect é usado quando eu quero voltar uma lista e nao um nome só e afins
        
        if (employeesHighSalaries.isEmpty()) {
            System.out.println("No employee with a salary greater than $4230.");
        } else {
            for (Customers e : employeesHighSalaries) {
                System.out.println(e);
            }
        }
        
        System.out.println("\n---------------------------\n");
        System.out.println("Updated list: removing employees with salary less than $1410.\n");
        
        salaryRemoved = customers.removeIf(x -> x.getSalary() < 1410);
        
        if (!salaryRemoved) {
            System.out.println("No salaries are less than $1410, the list remains the same.");
        } else if (customers.isEmpty()) {
            System.out.println("All employees were removed.");
        } else {
            for (Customers c : customers) {
                System.out.println(c);
            }
        }
        
        System.out.println("\n---------------------------\n");
        System.out.println("Highest salary: ");
        
        for (Customers x : customers) {
            if (x.getSalary() > highestSalary) {
                highestSalary = x.getSalary();
            }
        }
        
        if (customers.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("$" + highestSalary);
        }
        
        System.out.println("\n---------------------------\n");
        System.out.println("Updated list: adding 10% salary increase.\n");
        
        if (customers.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Customers c : customers) {
                c.increaseSalary(); //customers.get(x).increaseSalary(); pegando o funcionário na posição x e adicionando a função de aumentar o salário
                System.out.println(c);
                sum += c.getSalary(); // soma = soma + customers.get(x).getSalary();
            }
            
            System.out.printf("\nAverage salary: %.2f%n", (sum/customers.size()));
        }

        sc.close();
    }
}
