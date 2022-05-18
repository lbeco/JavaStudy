package collection;

import java.util.Arrays;

public class ArraysUtilTest {
    public static void main(String[] args) {
        int[] test = new int[]{7,5,3,2,8,7,6,0,1,9};

        System.out.println(Arrays.binarySearch(test,3));
        Arrays.sort(test);
        System.out.println(Arrays.binarySearch(test,3));


    }
}
