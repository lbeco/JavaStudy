package meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        int[][] dp = new int[n+1][7];
//        for(int i=1;i<n+1;i++){
//            for(int j=0;j<7;j++){
//                dp[i][j] = Integer.MIN_VALUE;
//            }
//        }
        Arrays.sort(num);
        int[] newNum = new int[n];
        for(int i=0;i<n;i++){
            newNum[n-1-i] = num[i];
        }



        for(int i=1;i<n+1;i++){
            for(int j=0;j<7;j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for(int j=0;j<7;j++){

                int val = dp[i-1][j] + newNum[i-1];

                int bucket = val;
                if(bucket<0){
                    bucket = bucket%7+7;

                }else{
                    bucket = bucket%7;
                }

                if(val > dp[i][bucket]){
                    dp[i][bucket] = val;
                }

            }
        }
        System.out.println(dp[n][0]);


    }
}
