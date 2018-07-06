package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 22:08 2018/7/1
 * @Description:
 */
public class Q3_5 {
    public static void main(String[] args) {
        IntSequence intSequence = IntSequence.constant(1);
        while (intSequence.hasNext()){
            System.out.println(intSequence.next());
        }
    }
}
