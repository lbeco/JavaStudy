package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] point = new int[n];
        for (int i = 0; i < n; i++) {
            point[i] = scanner.nextInt();
        }

        int left = point[0];
        int right = point[n - 1];
        double middle = (left + right) / 2.0;
        Arrays.sort(point);

        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (point[mid] > middle) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        int result1 = point[l];
        int result2 = point[l-1];
        int res1 = Math.abs((right - result1) - (result1 - left));
        int res2 = Math.abs((right - result2) - (result2 - left));

        System.out.println(Math.min(res1,res2));


    }


}
