package pdd;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Pdd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();
        for(int times=0;times<n;times++){
            int h = in.nextInt();
            int[] step = new int[h+1];
            for(int i=0;i<h;i++){
                step[i+1] = in.nextInt();
            }
            long[] dp = new long[h+1];
            dp[0]=1;
            for(int i=1;i<=h;i++){
                long height = step[i];
                for(int j=i-1;j>=0 && j >=i-k;j--){

                    if(height<=p){
                        dp[i] += dp[j];
                    }
                    height += step[j];
                }
            }
            for(int i=0;i<=h;i++){
                System.out.print(dp[i]);
            }
            System.out.println(dp[h]);

        }
    }
}
