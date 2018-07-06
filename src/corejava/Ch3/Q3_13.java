package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 23:46 2018/7/1
 * @Description:
 */
public class Q3_13 {
    public static Runnable makeRunnable(Runnable[] runnables){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (Runnable r:
                     runnables) {
                    r.run();
                }
            }
        };
        return runnable;
    }
    public static Runnable makeRunnable2(Runnable[] runnables) {

        return () -> {
            for (Runnable r :
                    runnables) {
                r.run();
            }
        };
    }
    public static void main(String[] args) {
        Runnable shemp = () -> System.out.println("Why don't I come up and see ya sometime when you're in the nude... I mean mood.");
        Runnable moe = () -> System.out.println("I got a tapeworm and that's good enough for him!");
        Runnable curly = () -> System.out.println("Burnt toast and a rotten egg? Whatta ya want that for?");
        Runnable[] tasks = { curly, moe, shemp };

        Runnable task = makeRunnable2(tasks);
        task.run();
    }
}
