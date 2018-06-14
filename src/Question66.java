/**
 * @Author: Skye
 * @Date: 10:29 2018/6/14
 * @Description: 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Question66 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows<1 || cols<1 || str == null){
            return false;
        }
        boolean[] visited = new boolean[rows*cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int pathIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix,rows,cols,str,visited,i,j,pathIndex)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,boolean[] visited,int row,int col,int pathIndex){
        if (pathIndex >= str.length){
            return true;
        }

        boolean hasPath = false;
        if ( row>=0 && row < rows && col >= 0 && col < cols &&
                matrix[row*cols + col] == str[pathIndex] && !visited[row*cols + col]){
            visited[row*cols + col] = true;
            pathIndex++;
            hasPath = hasPathCore(matrix,rows,cols,str,visited,row,col-1,pathIndex) ||
                    hasPathCore(matrix,rows,cols,str,visited,row,col+1,pathIndex) ||
                    hasPathCore(matrix,rows,cols,str,visited,row-1,col,pathIndex) ||
                    hasPathCore(matrix,rows,cols,str,visited,row+1,col,pathIndex);
            if (!hasPath){
                visited[row*cols + col] = false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        Question66 question66 = new Question66();
        char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a'};
        char[] str = new char[]{'a','b','s'};
        char[] str2 = new char[]{'a','b','a'};
        boolean has = question66.hasPath(matrix,3,3,str2);
        System.out.println(has);
    }

}
