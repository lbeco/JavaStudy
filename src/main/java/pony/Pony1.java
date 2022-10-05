package pony;


// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
public class Pony1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();

        long count = 0;
        long level = 0;
        long[] nums = new long[(int) n];
        long[] sort = new long[(int) n];
        for(int i=0;i<n;i++){
            long input = in.nextLong();
            nums[i] = input;
            sort[i] = input;
        }
        Arrays.sort(nums);
        int i = 0;
        for(i=0;i<n;i++){
            if (count + (n-i) * (nums[i] - level) <k){
                count = count + (n-i) * (nums[i] - level);
                level = nums[i];
                continue;
            }else{
                break;
            }
        }
        long more = (k - count)%(n-i);
        int c = 1;
        for(int j=0;j<n;j++){
            if(sort[j] <= level){
                continue;
            }
            if(more == c){
                System.out.println(j+1);
            }
            c++;
        }




    }
}