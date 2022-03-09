package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int num1 = nums[i];
            int index1 = i+1;
            int index2 = nums.length-1;
            while(index1<index2){
                if (num1 + nums[index1]+ nums[index2] >0){
                    index2--;
                }
                else if (num1 + nums[index1]+ nums[index2] <0){
                    index1++;
                }
                else{
                    List<Integer> resList = new ArrayList<Integer>();
                    resList.add(num1);
                    resList.add(nums[index1]);
                    resList.add(nums[index2]);
                    res.add(resList);
                    while(nums[index1] ==resList.get(1) ){
                        index1++;
                    }
                    while(nums[index2] ==resList.get(2) ){
                        index2--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc15 lc15 = new Lc15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        lc15.threeSum(nums);
    }
}