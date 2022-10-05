package pony;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Pony2 {
    char[][] map;
    int[][] dp;

    int[] path;

    int[] dummy;
    int n;
    int m;

    boolean isCycle;

    int[] cycle;
    public static void main(String[] args) {
        Pony2 main = new Pony2();
        main.run();

    }

    public void run(){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new char[n][m];
        dp = new int[n][m];
        in.nextLine();
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            char[] inputS = s.toCharArray();
            for(int j=0;j<m;j++){
                map[i][j] = inputS[j];
            }
        }
        dummy = new int[n*m];
        path = new int[n*m];
        int result = 0;
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                cycle = new int[]{-1,-1};
                System.arraycopy(dummy,0,path,0,n*m);
                // path = new int[n][m];
                isCycle = false;
                result = Math.max(search(i, j,0),result);
            }
        }
        System.out.println(result);

    }

    public  int search(int x, int y, int trace) {
        if(x <0 || x >= n || y<0 || y >=m){
            return 0;
        }
        if(path[x*m+y]!=0){
            // dp[x][y] = trace - path[x][y];
            cycle[0] = x;
            cycle[1] = y;
            isCycle = true;
            return trace - path[x*m+y]+1;
        }
        if(dp[x][y]!=0)return dp[x][y];

        int direct = getIndex(map[x][y]);
        trace++;

        int way =0;
        path[x*m+y] = trace;
        if(direct == 0){
            way = search(x-1,y,trace);
        }
        else if(direct == 1){
            way = search(x+1,y,trace);
        }
        else if(direct == 2){
            way = search(x,y-1,trace);
        }
        else if(direct == 3){
            way = search(x,y+1,trace);
        }
        if(isCycle){
            if(x == cycle[0] && y == cycle[1]){
                isCycle = false;

            }
            dp[x][y] = way;
            return way;
        }

        dp[x][y] = way+1;
        return way+1;
    }

    public static int getIndex(char c){
        if(c == '^') return 0;
        if(c == 'v') return 1;
        if(c == '<') return 2;
        if(c == '>') return 3;
        return -1;
    }
}