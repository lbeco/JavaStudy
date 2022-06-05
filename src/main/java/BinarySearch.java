public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 8, 11, 23, 25};
        int l, r;
        l = 0;
        r = nums.length - 1;

        int k = 7;
        while (l < r) {
            int m = (l + r) / 2;
            if (k > nums[m]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        System.out.println(nums[l]);
    }
}
