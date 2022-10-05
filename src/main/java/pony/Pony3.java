package pony;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Pony3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        for(int i=0;i<n-m+1;i++){
            int curr = nums[i];
            int target = curr;
            for(int j=i+1;j<i+m;j++){
                target = Math.min(nums[j],target);
            }
            for(int j=i;j<i+m;j++){
                nums[j]-=target;
            }
        }
        long res=0;
        for(int i=0;i<n;i++){
            res += (long)nums[i] ;
        }
        System.out.println(res);

    }
}