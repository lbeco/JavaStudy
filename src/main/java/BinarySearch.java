public class BinarySearch {
    public static void main(String[] args) {
        // 区间划分为 [l,mid]和[mid + 1, r]
        // int[] nums = new int[]{1, 2, 3, 6,7,7,7, 8, 11, 23, 25};
        int[] nums = new int[]{1, 2, 3, 6, 8, 11, 23, 25};
        int l, r;
        l = 0;
        r = nums.length - 1;

        int k = 7;
//        while (l < r) {
//            int m = (l + r) / 2;
//            if (k > nums[m]) { //左闭右开，若不等于则m不可能为答案
//                l = m+1;
//            } else {
//                r = m; // 右开，故m可以加入
//            }
//        }

        // 划分为[l,mid−1]和[mid,r]

        while (l < r) {
            int m = (l + r+1) / 2; // 当l=m时必须天花板除，免得死循环
            if (k >= nums[m]) {
                l = m;
            } else {
                r = m-1;
            }
        }
        //搜索的还是和mid相等的值，没有的话取下限

        //左边界要更新为l = mid时，我们就令 mid =(l + r + 1)/2，上取整，此时就不会因为rr取特殊值r = l + 1而陷入死循环了




        System.out.println(nums[l]);
        System.out.println(nums[r]);

        System.out.println(l);
        System.out.println(r);
    }
}
