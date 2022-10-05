package train;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,8,2,10,3,7,6,9};
        quickSort(nums,0, nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void quickSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int leftIndex = l;
        int rightIndex = r;
        int temp = nums[l];
        int index = l;
        while(leftIndex<rightIndex){
            while(leftIndex < rightIndex && nums[rightIndex] <= temp){
                rightIndex--;
            }
            nums[leftIndex] = nums[rightIndex];

            while(leftIndex < rightIndex && nums[leftIndex] >= temp){
                leftIndex++;
            }
            nums[rightIndex] = nums[leftIndex];
        }
        nums[leftIndex] = temp;

        quickSort(nums,l,leftIndex-1);
        quickSort(nums,leftIndex+1,r);

    }
}
