package AdvancedAlgorithm;

import java.util.Arrays;

public class Coffee {


    public static void main(String[] args) {
        // test number
        int[] dist = new int[]{1, 3, 5, 7, 9};
        int[] prize = new int[]{2, 3, 3, 3, 4};

        int res = coffee(dist, prize, 12, 4);
        System.out.println(res);
    }

    public static int coffee(int[] c, int[] p, int a2b, int d) {


        int len = c.length + 2;
        int[] dist = new int[len];
        int[] prize = new int[len];

        // initial dist and prize like:
        // place: cityA cafe1 cafe2 cafe3 cafe4 cafe5 cityB
        // dist:  0     1      3      5      7    9     12
        // prize: 0     2      3      1      3    4     0
        dist[0] = 0;
        for (int i = 1; i < len-1; i++) {
            dist[i] = c[i-1];
            prize[i] = p[i-1];
        }

        dist[len - 1] = a2b;
        prize[len-1] = 0;

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

//        set link matrix
//        boolean[][] connect = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (dist[j] - dist[i] <= d) {
                    dp[j] = Math.min(dp[j],dp[i]+prize[j]);
                }else{
                    break;
                }
            }
        }

        // if it is impossible to reach, return -1
        int res = -1;
        if (dp[len-1]<Integer.MAX_VALUE){
            res = dp[len-1];
        }
        return res;

    }
}
