package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 18:25 2018/7/1
 * @Description:
 */
public class Q3_4 {
    public static void main(String[] args) {
        IntSequence intSequence = IntSequence.of(1,2,4,5,6);
        while (intSequence.hasNext()){
            System.out.println(intSequence.next());
        }
    }
}
