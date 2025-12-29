package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale. US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        
        List<Employee> employee = new ArrayList<>();
        int x;
        
        for (x=0; x<n; x++) {
            System.out.println("\nEmployee #" + (x+1));
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            
            while (hasId(employee, id)) { //enquanto for digitado um id que já existe (tipo while True)...
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            
            Employee emp = new Employee(id, name, salary);
            employee.add(emp); // adicionando a lista employee no objeto instanciado emp (ou seja, cada emp tem um id, nome e salário e na posição x da lista employee ta cada emp
        }
        
        System.out.print("\nEnter the employee id that will have salary increase: ");
        int idSalaryIncrease = sc.nextInt(); // criando um novo p que possa ser comparado
        
        Integer pos = position(employee, idSalaryIncrease); //se a função é Integer a variável também
        
        /* ou
        Employee emp = employee.stream().filter(x -> x.getId() == idSalaryIncrease).findFirst().orElse(null);
        
        Aqui estou buscando na lista a primeira ocorrência de um funcionário que tenha o id igual que eu digitei
        Aqui eu fiz uma busca usando o stream, chamei a função filter que filtra minha lista só aqueles elementos que atendem o predicado+
        + Esse predicado diz que só quer os elementos x e funcionários x tal que o x.getId seja = idSalaryIncrease e pega o 1°, e se não existir, retorna nulo
        */
        
        if (pos == null) { // ou if (emp == null)...
            System.out.println("This id doesn't exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            
            employee.get(pos).increaseSalary(percentage); // ou emp.increaseSalary(percentage); //antes de fazer qualquer coisa tem que ter o list.get(x)
        }
        
        System.out.println("\nList of employees: ");
        for (x=0; x<n; x++) {
            System.out.printf("%d, %s, %.2f%n", employee.get(x).getId(), employee.get(x).getName(), employee.get(x).getSalary());
        }
        
        /* ou
        for (Employee e : employee) { (nao pode ser a mesma q emp)
            System.out.println(e);
        }
        */
        
        sc.close();
    }
    
    public static Integer position(List<Employee> employee, int idSalaryIncrease) { // relembrando, ta fora do main então podem ser variáveis iguais ou diferentes
        for (int x=0; x < employee.size(); x++) {
            if (employee.get(x).getId() == idSalaryIncrease) { //se a lista na posição x pegar o id da lista e for igual ao id digitado a posição dele é x
                return x; //a posição é tal
            }
        }
        return null;
    } 
    
    public static boolean hasId(List<Employee> employee, int id) {
        Employee emp = employee.stream().filter(x -> x.getId() == id).findFirst().orElse(null); //o id existe? verdadeiro ou falso
        return emp != null; // vai retornar verdadeiro se o id existe
    }
}
