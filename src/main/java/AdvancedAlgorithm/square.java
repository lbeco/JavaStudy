package AdvancedAlgorithm;

import java.util.Arrays;

public class square {

    public static void main(String[] args) {
        int n = 5;
        int[][] square = new int[][]
                {
                        {0, 2, 3, 8, 7},
                        {4, 2, 1, 8, 6},
                        {3, 7, 8, 9, 10},
                        {3, 7, 8, 9, 10},
                        {3, 7, 8, 9, 10}};
        int[][] square2 = new int[][]
                {
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {10, 10, 10, 10, 10},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0}};
        int[] res = getSquare(square2, n);
        Arrays.stream(res).forEach(System.out::println);


    }

    private static int[] getSquare(int[][] square, int n) {
        int sum = 0;
        int[][] sumSquare = new int[n][n];
        int[] res = new int[n]; // result of every column

        for (int j = 0; j < n; j++) {
            int columnSum = 0;
            for (int i = 0; i < n; i++) {
                columnSum += square[i][j];
                sumSquare[i][j] = columnSum;
                sum += square[i][j];
            }
        }

        int[] dp = new int[sum + 1]; // dp[i] means largest available sum value smaller than i
        int[][] pre = new int[sum + 1][2]; // store pre path for

        for (int j = 0; j < n; j++) {
            int[] newDp = Arrays.copyOf(dp, sum + 1);
            for (int i = 0; i < n; i++) {
                for (int k = sumSquare[i][j]; k < sum + 1; k++) {
                    if (dp[k] < dp[k - sumSquare[i][j]] + sumSquare[i][j]) {
                        newDp[k] = dp[k - sumSquare[i][j]] + sumSquare[i][j];
                        pre[k] = new int[]{i, j};
                    }
                }
            }
            dp = Arrays.copyOf(newDp, sum + 1);
        }

        int target = sum / 2;


        int res1 = dp[target];
        int res2 = -1;


        for (int i = target + 1; i < sum; i++) {
            if (dp[i] > dp[i - 1]) {
                res2 = dp[i];
                break;
            }
        }
        int bestLoss;
        int recall;
        if (Math.abs(res1 - target) > Math.abs(res2 - target)) {
            bestLoss = Math.abs(res2 - target);
            recall = res2;
        } else {
            bestLoss = Math.abs(res1 - target);
            recall = res1;
        }
        while (recall > 0) {
            res[pre[recall][1]] = pre[recall][0];
            recall -= sumSquare[pre[recall][0]][pre[recall][1]];
        }

        System.out.println("Best loss:" + bestLoss);
        return res;
    }
}
