public class LimitedMaxHeap {

    int[] array = new int[1024];
    int index;
    int maxValue ;
    public LimitedMaxHeap(int n){
        maxValue = n;
        index = 0;
    }

    public static void main(String[] args) {
        LimitedMaxHeap h = new LimitedMaxHeap(3);
        h.push(1);
        h.push(2);
        h.push(3);
        h.push(11);
        h.push(6);
        h.push(9);


    }

    public void push(int n){
        array[index] = n;
        int cur = index;
        while(array[cur]>array[(cur-1)/2]){
            int temp = array[cur];
            array[cur] = array[(cur-1)/2];
            array[(cur-1)/2] = temp;
            cur = (cur-1)/2;
        }
        index++;
    }
}
