package leetcode;

public class Lc416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i=0;i<len;i++){
            sum+=nums[i];
        }

        if (sum % 2 ==1){
            return false;
        }
        int target = sum/2;

        boolean [][]dp = new boolean[len][target+1];
        dp[0][0] = true;
        if (nums[0]<target){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(j == nums[i]){
                    dp[i][j] = true;
                    continue;
                }
                if(j > nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    continue;
                }

            }
        }
        return dp[len-1][target];

    }
    public static void main(String[] args) {
        Lc416 lc416 = new Lc416();

        lc416.canPartition(new int[]{2,2,3,5});
    }
}
