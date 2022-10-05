package netease;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class NetEase3 {

    public static int comp(int[] x, int[] y){


        int x1 = Math.min(x[2],y[2]) - Math.max(y[0],x[0]);
//        if(y[2] > x[2] && y[0] < x[2] ){
//            x1 = x[2]-Math.max(y[0],x[0]);
//        }
//        if(y[2] < x[2] && y[2] > x[0] ){
//            x1 = y[2]-Math.max(y[0],x[0]);
//        }
        int y1 = Math.min(x[3],y[3]) - Math.max(y[1],x[1]);


        int conver = x1*y1;
        int sum = (x[3]-x[1]) * (x[2]-x[0]) + (y[3]-y[1]) * (y[2]-y[0]);
        if(x1>0 || y1 >0){
            return sum-conver;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        for(int t = 0;t<times;t++){
            int s = in.nextInt();
            List<int[]> squares = new ArrayList<>();
            /**
             2
             4
             0 0 2 2
             1 1 4 3
             2 4 4 7
             2 5 3 6
             3
             0 0 1 1
             1 1 2 2
             1 0 2 1
             */

            for(int i=0;i<s;i++){
                int[] input = new int[4];
                input[0] = in.nextInt();
                input[1] = in.nextInt();
                input[2] = in.nextInt();
                input[3] = in.nextInt();

                squares.add(input);
            }
            int result = 0;
            boolean[] flag = new boolean[squares.size()];

            for(int i=0;i<squares.size();i++){
                if(flag[i])continue;
                int[] source = squares.get(i);

                for(int j=i+1;j<squares.size();j++){
                    if(flag[j])continue;

                    int[] target = squares.get(j);
                    int res = comp(source,target);
                    if(res != -1){
                        // System.out.println(res);
                        result += res;
                        flag[i] = true;
                        flag[j] = true;
                        break;
                    }

                }
            }
            System.out.println(result);


        }
    }
}