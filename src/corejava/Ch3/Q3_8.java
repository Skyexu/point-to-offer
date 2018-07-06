package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 22:26 2018/7/1
 * @Description:
 */
public class Q3_8 {
    public static void main(String[] args) {
        Runnable r1 = new Greeter("hello",10);
        Runnable r2 = new Greeter("skye",20);
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();
    }
}
