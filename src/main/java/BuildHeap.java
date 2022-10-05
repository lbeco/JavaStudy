public class BuildHeap {

    public static void main(String[] args) {
        int[] data = new int[]{2,6,1,7,4,9,8,0,11};
        buildHeap(data,data.length-1);
        for(int i:data){
            System.out.println(i);
        }

    }


    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 0; --i) {
            heapify(a, n, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static  void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
