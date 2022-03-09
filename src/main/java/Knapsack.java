public class Knapsack {


    public static void main(String[] args) {
        int len = 10;
        int maxV = 20;

        int[] w = new int[]{1,4,9,8,16,5,2,2,4,8};
        int[] v = new int[]{3,2,15,10,9,8,4,6,33,2};
        int[][] keep = new int[len+1][maxV+1];

        int[][] dp = new int [len+1][maxV+1];
        for(int i=0;i<len;i++) {
            dp[0][i] = 0;
        }

        for(int i=1;i<=len;i++){
            for(int j=0;j<=maxV;j++){
                if (j>=v[i-1]){
                    if(dp[i-1][j]>dp[i-1][j-v[i-1]] + w[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        keep[i][j] = 1;
                        dp[i][j] = dp[i-1][j-v[i-1]] + w[i-1];
                    }


                }
                else{
                    dp[i][j] = dp[i-1][j];
                    keep[i][j] = 0;
                }

            }
        }
        for(int i=1;i<len+1;i++){
            System.out.print(keep[i][maxV]);
        }
        System.out.println();
        System.out.println(dp[len][maxV]);
    }
}
