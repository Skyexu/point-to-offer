import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 公园入口到出口最短路径
 */

public class T3 {

    static class Road{
        char c;
        int x;
        int y;
        public Road(char c,int x,int y){
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        Deque<Road> q = new LinkedList<>();
        String s = sc.nextLine();
        n = Integer.valueOf(s);

        int x,y;
        String[] str = new String[n];
        char[][] ch = new char[n][n];

        //标记数组，是否访问过
        boolean[][] flag = new boolean[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                flag[i][j]=false;

        for(int i=0;i<n;i++){
            str[i] = sc.nextLine();
            ch[i] = str[i].toCharArray();
            System.out.println("str["+i+"]=="+str[i]);
            for(int j=0;j<n;j++){
                System.out.println("ch["+i+"]["+j+"]="+ch[i][j]);
                if(ch[i][j] == '*'){
                    x = i;
                    y = j;
                    q.add(new Road('*',x,y));
                    flag[x][y]=true;
                    System.out.println("x="+x+",y="+y);
                }
            }
        }


        int cnt = 0;
        while(!q.isEmpty()){

            int size = q.size();
            boolean f = false;
            while(size>0){
                Road r = q.remove();
                int xx = r.x;
                int yy = r.y;
                flag[xx][yy]=true;

                if(r.c == '@'){
                    System.out.println(cnt);
                    return;
                }else{

                    if(yy-1>=0 && flag[xx][yy-1]==false && ch[xx][yy-1] != '#'){
                        q.add(new Road(ch[xx][yy-1],xx,yy-1));
                        f =true;
                    }
                    if(yy+1<n && flag[xx][yy+1]==false && ch[xx][yy+1] != '#'){
                        q.add(new Road(ch[xx][yy+1],xx,yy+1));
                        f = true;
                    }
                    if(xx-1>=0 && flag[xx-1][yy]==false && ch[xx-1][yy] != '#'){
                        q.add(new Road(ch[xx-1][yy],xx-1,yy));
                        f = true;
                    }
                    if(xx+1<n && flag[xx+1][yy]==false && ch[xx+1][yy]!='#'){
                        q.add(new Road(ch[xx+1][yy],xx+1,yy));
                        f = true;
                    }
                }

                size--;

            }
            if(f ==true)
                cnt++;

        }




    }
}