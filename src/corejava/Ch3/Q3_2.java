package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 18:05 2018/7/1
 * @Description:
 */
public class Q3_2 {
    public static Measurable largest(Measurable[] objects){
        Measurable result = objects[0];
        String name = "";
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > result.getMeasure()){
                result = objects[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("Larry",25000),
                new Employee("Moe", 16000),
                new Employee("Curly", 22000)
        };
        // 转换为接口实现类（父类），因为 Measurable 类没有 getName() 方法
        Employee employee = (Employee) largest(employees);
        System.out.println(employee.getName());
    }
}
