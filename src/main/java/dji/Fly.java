package dji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        // List<Integer> data  = new ArrayList<>();
        String[] data = res.split(" ");
        int[] nums = new int[data.length];
        for(int i=0;i<data.length;i++){

            nums[i] = Integer.valueOf(data[i]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        System.out.println(dp[nums.length-1]);
    }

}

// 2 7 1 3 5