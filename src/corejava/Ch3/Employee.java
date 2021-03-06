package corejava.Ch3;

public class Employee implements Measurable{
    private String name;
    private double salary;

    public Employee(){}
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}
