package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 22:32 2018/7/1
 * @Description:
 */
public class Q3_9 {
    public static void runTogether(Runnable... tasks){
        for (Runnable r:
             tasks) {
            Thread thread = new Thread(r);
            thread.start();
        }
    }
    public static void runInOrder(Runnable... tasks){
        for (Runnable r:
                tasks) {
            r.run();
        }
    }
    public static void main(String[] args) {
        Runnable r1 = new Greeter("hello",10);
        Runnable r2 = new Greeter("skye",20);
        runInOrder(r1, r2);
        System.out.println("------------------");
        runTogether(r1, r2);
    }
}
