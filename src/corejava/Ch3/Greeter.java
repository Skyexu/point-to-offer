package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 22:27 2018/7/1
 * @Description:
 */
public class Greeter implements Runnable{
    private String words;
    private int n;
    public Greeter(String words,int n){
       this.words = words;
       this.n = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(words);
        }

    }
}
