public class MaxHeap {
    int[] val = new int[1024];
    int index;

    public MaxHeap(){
        index=0;
    }

    public int getMax(){
        if(index <= 0){
            return -1;
        }
        return val[0];
    }

    public void push(int num){
        val[index] = num;
        int cur = index;
        while(val[cur]>val[(cur-1)/2]){
            int temp = val[cur];
            val[cur] = val[(cur-1)/2];
            val[(cur-1)/2] = temp;
            cur = (cur-1)/2;
        }
        index++;
    }


    public int pop(){
        if(index<=0){
            return -1;
        }
        int max = val[0];
        val[0] = val[index-1];
        index--;
        int res = 0;
        while(val[res] < val[res*2+1] || val[res] < val[res*2+2]){
            if(val[res*2+1]<val[res*2+2]){
                int temp = val[res*2+2];
                val[res*2+2] = val[res];
                val[res] = temp;
                res = res*2+2;
            }else{
                int temp = val[res*2+1];
                val[res*2+1] = val[res];
                val[res] = temp;
                res = res*2+1;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        MaxHeap m = new MaxHeap();
        m.push(1);
        m.push(2);
        m.push(11);
        m.push(9);
        m.push(4);
        m.push(7);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        m.push(11);
        m.push(9);
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.getMax());
        System.out.println(m.getMax());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }

}
