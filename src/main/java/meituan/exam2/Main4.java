package meituan.exam2;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l1 = scanner.nextInt();
        int l2 = scanner.nextInt();
        int[] s1 = new int[l1];
        int[] s2 = new int[l2];
        for (int i = 0; i < l1; i++) {
            s1[i] = scanner.nextInt();
        }
        for (int i = 0; i < l2; i++) {
            s2[i] = scanner.nextInt();
        }
        long[][] dp = new long[l1+1][l2+1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i-1][0] + Math.abs(s1[i-1]);
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i-1] + Math.abs(s2[i-1]);
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                long swapCost = dp[i-1][j-1] + Math.abs(s1[i-1]-s2[j-1]);
                long removeCost = Math.min(dp[i][j-1] + Math.abs(s2[j-1]),dp[i-1][j] + Math.abs(s1[i-1]));
                dp[i][j] = Math.min(swapCost,removeCost);
            }
        }
        System.out.println(dp[l1][l2]);

    }
}
