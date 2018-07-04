package examination.sixtest;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 公园入口到出口最短路径
 *
 * 又是晴朗的一天，牛牛的小伙伴们都跑来找牛牛去公园玩。但是牛牛想呆在家里看E3展，不想出去逛公园，
 * 可是牛牛又不想鸽掉他的小伙伴们，于是找来了公园的地图，发现公园是由一个边长为n的正方形构成的，
 * 公园一共有m个入口，但出口只有一个。公园内有一些湖和建筑，牛牛和他的小伙伴们肯定不能从他们中间穿过，
 * 所以只能绕行。牛牛想知道他需要走的最短距离并输出这个最短距离。
 *
 * 输入描述:
 第一行输入一个数字n(1≤n≤1000)表示公园的边长
 接下来会给你一个n*n的公园地图，其中 . 表示公园里的道路，@表示公园的入口，
 *表示公园的出口，#表示公园内的湖和建筑。牛牛和他的小伙伴们每次只能上下左右移动一格位置。
 输入保证公园入口个数m(1≤m≤10000)且所有的入口都能和出口相连。


 输出描述:
 输出牛牛需要行走的最短距离。
 输入例子1:
 10
 .@....##@.
 ......#...
 ...@..#...
 ###.......
 ....##..#.
 ...####...
 @...##....
 #####.....
 ..##*####.
 #.........

 输出例子1:
 16
 https://www.nowcoder.com/discuss/84527
 解法：
 1. 反向 BFS ，从出口出发，碰到入口输出层数即可
 2. 正向 BFS，假象有一个超级起点，把这个起点连接上所有的入口，那么，这个题不就相当于一个入口一个出口了么。
    将每个入口都进队列，不断将上下左右入队列，可以记录到每个点的最短距离，碰到出口结束。
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