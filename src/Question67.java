/**
 * @Author: Skye
 * @Date: 15:19 2018/6/14
 * @Description: 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Question67 {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0){
            return 0;
        }
        boolean[] visited = new boolean[rows*cols];

        int[] countNum = new int[1];
        countNum[0] = 0;
        moving(threshold,rows,cols,countNum,0,0,visited);
        return countNum[0];
    }

    private void moving(int threshold, int rows, int cols,int[] countNum,int row,int col,boolean[] visited){
        if (row < rows && col < cols && row >= 0 && col >=0 && !visited[row*cols + col] && sumNum(row,col) <= threshold){
            visited[row*cols + col] = true;
            countNum[0]++;
            moving(threshold,rows,cols,countNum,row,col-1,visited);
            moving(threshold,rows,cols,countNum,row,col+1,visited);
            moving(threshold,rows,cols,countNum,row-1,col,visited);
            moving(threshold,rows,cols,countNum,row+1,col,visited);
        }
    }

    private int sumNum(int x,int y){
        int res = 0;
        while (x > 0){
            res +=  x%10;
            x = x / 10;
        }
        while (y > 0){
            res +=  y%10;
            y = y /10;
        }
        return res;
    }

    public static void main(String[] args) {
        Question67 question67 = new Question67();
        System.out.println(question67.movingCount(2,3,3));
    }
}
