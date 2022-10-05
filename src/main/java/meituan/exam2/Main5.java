package meituan.exam2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] rocket = new int[n];
        int[] weight = new int[m];

        int[] list = new int[10010];
        for (int i = 0; i < n; i++) {
            rocket[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            weight[i] = scanner.nextInt();
        }
        Arrays.sort(weight);
        int index = 0;
        for (int i = 0; i < 10010; i++) {
            if(index <m){
                if (i < weight[index]) {
                    list[i] =  weight[index];
                }else {
                    while (index <m && i > weight[index]) {
                        index++;
                    }
                    if(index <m){
                        list[i] =  weight[index];
                    }else{
                        list[i] =  -1;
                    }

                }
            }else{
                list[i] =  -1;
            }

        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int val = rocket[i];
            if(list[val] >0){
                res += list[val];
            }else{
                res = -1;
                break;
            }
        }
        System.out.println(res);
    }


    }


