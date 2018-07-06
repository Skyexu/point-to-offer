package corejava.Ch3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Skye
 * @Date: 23:50 2018/7/1
 * @Description:
 */
public class Q3_14 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Larry",25000),
                new Employee("Moe", 16000),
                new Employee("Curly", 22000)
        };
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
        for (Employee employee: employees) {
            System.out.println(employee.getName());
        }
    }
}
