package netease;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;
import java.util.Scanner;
public class NetEase4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] nums = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)->b-a);


        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
            // pq.add(in.nextInt());
        }
        Arrays.sort(nums);
//         for(int i=0;i<n;i++){
//             System.out.print(nums[i]);
//         }
        int i;
        for(i=n-1;i>0;i--){
            int next = nums[i-1];
            int sub = 0;
            for(int j=n-1;j>=i;j--){
                sub += (nums[j]- next)/x +1;
            }
            if(sub >=k){
                break;
            }
            // System.out.println( "sub"+sub);
        }
        i--;
        for(int j=n-1;j>i;j--){
            int base = (nums[i] /x) *x;
            int sub = ((nums[j]- base)/x );
            nums[j] -= sub*x;
            k -= sub;
        }
        int index = i;
//         for(int i=0;i<n;i++){
//             System.out.println(k);
//         }
//        if(k ==0){
//            System.out.println(nums[index]);
//            return;
//        }
        int[] addUp = new int[x];
        int base = (nums[index]/5) *5;


        for(i=n-1;i>=index;i--){
            if(nums[i] > base)
            addUp[(nums[i]%x +x)%x]++;
        }
        for(i=x-1;i>=0;i--) {
            if (k >= addUp[i] || addUp[i] ==0) {
                k -= addUp[i];
            } else {
                System.out.println(i + base);
                break;
            }
        }
//        for(i=k;i>0;){
//            int val = pq.poll();
//            int next  = pq.peek();
//            int cnt = (val - next) / x + 1;
//            int sub = Math.min(cnt,i);
//            val -= sub * x;
//            i -= sub;
//
//            pq.add(val);
//        }
//        System.out.println(pq.peek());


    }
}