public class TopK {
    /**
     * top k 算法：
     * 首先，构建最小堆
     * 后续遍历时，每一个数和最小堆的顶比较，若较大，则pop出最小堆顶，压入当前数字。
     */

    int[] array = new int[1024];
    int index;
    int maxValue ;
    public TopK(int n){
        maxValue = n;
        index = 0;
    }

    public static void main(String[] args) {
        TopK h = new TopK(3);
        int[] nums = new int[]{1,5,23,8,7,4,99};

        int k = 3;
        for(int i=0;i<k;i++){
            h.push(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(h.peek()<nums[i]){
                h.pop();
                h.push(nums[i]);
            }
        }

        return;



    }



    public void push(int n){
        /*
            push时，压入数据放在最后，然后和前面的数字进行比较。
         */
        array[index] = n;
        int cur = index;
        while(array[cur]<array[(cur-1)/2]){
            int temp = array[cur];
            array[cur] = array[(cur-1)/2];
            array[(cur-1)/2] = temp;
            cur = (cur-1)/2;
        }
        index++;
    }

    public int peek(){
        return array[0];
    }

    public void pop(){
        array[0] = array[index-1]; // 获取最后一位数，放在根处
        index--;
        int res = 0;
        // 同两个子节点进行比较
        while((array[res]>array[res*2+1] && res*2+1 < index )
                || (array[res]>array[res*2+2] && res*2+2 < index)){
            if(array[res*2+1]<array[res*2+2]){ // 和小的进行置换
                int temp = array[res];
                array[res] = array[res*2+1];
                array[res*2+1] = temp;
                res = res*2+1;
            }
            else{
                int temp = array[res];
                array[res] = array[res*2+2];
                array[res*2+2] = temp;
                res = res*2+2;
            }
        }


    }
}
