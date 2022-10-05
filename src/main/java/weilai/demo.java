package weilai;

public class demo {
}


/**
 *

 import java.util.Scanner;

 public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int n = sc.nextInt();
 int[] input = new int[n];
 for(int i = 0; i < n; i++){
 int x = sc.nextInt();
 input[i] = x;

 }

 int[][] dp = new int[n+1][n+1];
 int res = 0;
 for(int i=0; i<n;i++){
 dp[i][i+1] = input[i];
 res = Math.max(res,dp[i][i+1]);
 }


 for(int l=1;l<n;l++){
 for(int i=0;i<n-l;i++){
 dp[i][i+l] = dp[i][i+l-1] + input[i+l-1];
 res = Math.max(res,dp[i][i+l]/l);
 }
 }
 System.out.println(res);
 return ;

 }
 }
 */