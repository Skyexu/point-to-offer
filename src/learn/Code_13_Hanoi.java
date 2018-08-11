package learn;

/**
 * @Author: Skye
 * @Date: 17:54 2018/8/1
 * @Description:  汉诺塔问题
 */
public class Code_13_Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    /**
     *
     * @param N 塔中需要处理的数目
     * @param from 转移的塔
     * @param to   目标塔
     * @param help 辅助塔
     */
    public static void process(int N,String from,String to ,String help){
        if (N == 1){
            System.out.println("move 1 " + " from " + from + " to " + to);
        }else {
            // N-1个块，先从转移的塔移动到辅助塔
            process(N-1,from,help,to);

            // 再将 N 号块移动到目标塔
            System.out.println("move " + N + " from " + from + " to " + to);

            // 最后将 N-1 个块移动到目标塔
            process(N-1,help,to,from);
        }
    }
    public static void moveLeftToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to right");
        }
        moveLeftToMid(N - 1);
        System.out.println("move " + N + "from left to right");
        moveMidToRight(N - 1);
    }

    public static void moveRightToLeft(int N) {

    }

    public static void moveLeftToMid(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to mid");
        }
        moveLeftToRight(N - 1);
        System.out.println("move " + N + "from left to mid");
        moveRightToMid(N - 1);
    }

    public static void moveMidToLeft(int N) {

    }

    public static void moveRightToMid(int N) {

    }

    public static void moveMidToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from mid to right");
        }
        moveMidToLeft(N - 1);
        System.out.println("move " + N + "from mid to right");
        moveLeftToRight(N - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
