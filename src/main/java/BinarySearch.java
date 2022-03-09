public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6, 8, 11, 23, 25};
        int l, r;
        l = 0;
        r = nums.length - 1;

        int k = 20;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (k >= nums[m]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        System.out.println(nums[l]);
    }
}
