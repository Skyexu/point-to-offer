package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 17:48 2018/7/1
 * @Description:
 */
public class Q3_1 {
    public static double average(Measurable[] objects){
        double average = 0.0;
        for (int i = 0; i < objects.length; i++) {
            average += objects[i].getMeasure();
        }
        average /= objects.length;
        return average;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Larry",25000),
                new Employee("Moe", 16000),
                new Employee("Curly", 22000)
        };
        System.out.println(average(employees));
    }
}
