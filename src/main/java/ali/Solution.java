package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            int len = a.length();
            int[] num = new int[len];
            int max = 0;
            for(int i=0;i<len;i++){
                if(a.charAt(i)<='9' && a.charAt(i) >= '0'){
                    num[i] = a.charAt(i) - '0';
                }else {
                    num[i] = a.charAt(i) - 'A' + 10;
                }
                max = Math.max(num[i]+1,max);
            }
            List<Integer> resList = new ArrayList<>();

            for(int i=max;i<=16;i++){
                int dec = toDec(num,i);
                if(!resList.contains(dec)){
                    resList.add(dec);
                }

               // System.out.println(toDec(num,i));
            }
            resList.sort(( c, b)->c-b);
            for(int l : resList){
                System.out.println(l);
            }


    }
    public static int toDec(int[] num, int n){
        long res = 0;
        for(int i=0;i<num.length;i++){
            res = (res * n + num[i])%1000000007;
        }
        return (int)res;
    }
}