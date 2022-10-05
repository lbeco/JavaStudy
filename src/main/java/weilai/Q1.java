package weilai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            input[i] = x;

        }

        int[] max = new int[n];
        List<Integer> maxIndex = new ArrayList<>();
        int maxValue = 0;

        for(int i=0;i<n;i++){
            max[i] = input[i];
            maxIndex.add(i);
            maxValue = Math.max(max[i],maxValue);

        }

        List<Integer> newIndex = new ArrayList<>();

        for(int l=1;l<n;l++){



        }
        System.out.println(maxValue);


    }
}