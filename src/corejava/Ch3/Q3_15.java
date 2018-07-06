package corejava.Ch3;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Skye
 * @Date: 23:53 2018/7/1
 * @Description:
 */
public class Q3_15 {
    public class RandomSequence implements IntSequence {
        private Random generator =  new Random();
        private int low, high;
        RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new Q3_15().new RandomSequence(low, high);
    }
    public static void main(String[] args) {
        IntSequence randomInts = randomInts(1, 69);
        int[] ticket = new int[6];
        for (int i = 0; i < 5; i++) {
            ticket[i] = randomInts.next();
        }
        Arrays.sort(ticket, 0, 4);

        ticket[5] = randomInts(1,29).next(); //PowerBall

        System.out.println(Arrays.toString(ticket));
    }
}
