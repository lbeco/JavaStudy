package AdvancedAlgorithm;

import java.util.Arrays;

public class Square2 {

    private static int num;
    private static int sum;

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

        int[][] square3 = new int[][]
                {
                        {1, 3, 1},
                        {2, 4, 2},
                        {5, 1, 3}};


        int[] res = getSquare(square3, 3);
        Arrays.stream(res).forEach(System.out::println);


    }

    private static int[] getSquare(int[][] square, int n) {
        num = n;
        sum = 0;
        int[][] sumSquare1 = new int[n][n];
        int[][] sumSquare2 = new int[n][n];


        for (int j = 0; j < n; j++) {
            int columnSum = 0;
            for (int i = 0; i < n; i++) {
                columnSum += square[i][j];
                sumSquare1[i][j] = columnSum;
                sum += square[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            int columnSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                columnSum += square[i][j];
                sumSquare2[n - 1 - i][j] = columnSum;
            }
        }

        int[][] pre1 = new int[sum + 1][2]; // store pre path for
        int res1 = getDp(sumSquare1, pre1);

        int[][] pre2 = new int[sum + 1][2]; // store pre path for
        int res2 = getDp(sumSquare2, pre2);

        int target = sum / 2;
        int[] res;

        if (Math.abs(res1 - target) > Math.abs(res2 - target)) {
            res = getRes(sumSquare2, pre2, res2);
        } else {
            res = getRes(sumSquare1, pre1, res1);
        }
        return res;
    }

    private static int[] getRes(int[][] sumSquare, int[][] pre, int recall) {
        int[] res = new int[num];
        Arrays.fill(res,-1);// result of every column
        while (recall > 0) {
            res[pre[recall][1]] = pre[recall][0];
            recall -= sumSquare[pre[recall][0]][pre[recall][1]];
        }
        return res;
    }

    private static int getDp(int[][] sumSquare, int[][] pre) {
        int target = sum / 2;
        // dp[i] means largest available sum value smaller than i
        int[] dp = new int[target + 1];
        for (int j = 0; j < num; j++) {
            int[] newDp = Arrays.copyOf(dp, target + 1);
            for (int i = 0; i < num; i++) {
                for (int k = sumSquare[i][j]; k < target + 1; k++) {
                    if (dp[k] < dp[k - sumSquare[i][j]] + sumSquare[i][j]) {
                        newDp[k] = dp[k - sumSquare[i][j]] + sumSquare[i][j];
                        pre[k] = new int[]{i, j};
                    }
                }
            }
            dp = Arrays.copyOf(newDp, target + 1);
        }

        return dp[target];
    }
}
