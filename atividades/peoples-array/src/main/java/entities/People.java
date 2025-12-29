package entities;

public class People {
    
    private String name;
    private int age;
    private double height, grade1, grade2, finalGrade;
    
    public People(String name, int age, double height, double grade1, double grade2, double finalGrade) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.finalGrade = 0.0;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade) {
        this.grade1 = grade;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

}