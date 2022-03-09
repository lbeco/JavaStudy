import java.util.*;


class Solution {


    public void sortColors(int[] nums) {
        int[] intList = new int[301];

        for (int i = 0; i < nums.length; i++) {
            intList[nums[i]]++;
        }
        for (int i = 0; i < intList.length; i++) {
            intList[nums[i]]++;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {4, 3}, {8, 4}, {2, 4}, {1, 8}, {8, 9}};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,(a,b)->a-b);

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(10,(a,b)->a[1]-b[1]);

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        Solution solution = new Solution();
//        solution.letterCombinations("1234");



    }
}



