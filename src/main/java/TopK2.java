import java.util.Arrays;
import java.util.Random;

class TopK2 {
    Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{1,6,4,8,3,7,2,9,11,14,15,13,14,12};
        TopK2 topK2 = new TopK2();
        int res = topK2.findKthLargest(nums,7);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ?
                    quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

