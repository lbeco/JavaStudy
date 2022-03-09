import java.util.Arrays;

public class QuickSort2 {


    public static void main(String[] args) {


        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

        quicksort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }



    private static void quicksort(int[] arr, int leftIndex, int rightIndex) {
        if(leftIndex>=rightIndex){
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        int key = arr[leftIndex];

        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            arr[left] = arr[right];

            while (right > left && arr[left] <= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = key;
        quicksort(arr,leftIndex,left-1);
        quicksort(arr,left+1,rightIndex);
        return;
    }


}
