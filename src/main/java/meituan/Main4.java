package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int top = n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            res += num[i];
        }

        if(n %2==0){
            top = n-1;
        }
        for(int i=0;i<n;i++){
            for(int j=2;j<=top-1;j+=2){
                if(i+j>=n){
                    break;
                }
                int[] com ;
                com = Arrays.copyOfRange(num,i,i+j+1);
                Arrays.sort(com);
                res += com[j/2];
            }
        }



        System.out.println(res);
    }
}
