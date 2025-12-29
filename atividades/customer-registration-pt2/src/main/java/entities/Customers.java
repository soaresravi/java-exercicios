package entities;

import java.util.List;

public class Customers {
    
    private String name;
    private Double salary;
    
    public Customers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    public void increaseSalary() {
        salary += salary * 10 / 100;
    }
    
    public String toString() {
        return name + ". $" + String.format("%.2f", salary);
    }
}
