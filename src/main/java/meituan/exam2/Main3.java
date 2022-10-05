package meituan.exam2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] p = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o2[0], o1[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            long add = (long) (100 - p[i]) * cost[i];
            pq.add(new long[]{add,i});
        }
        long finalValue = 0;
        for(int i=0;i<r;i++){
            long[] res = pq.poll();
            finalValue += cost[(int)res[1]]*100;

        }
        while(pq.size()>0){
            long[] res = pq.poll();
            finalValue += (long) cost[(int) res[1]] * p[(int)res[1]];
        }
//        float res = (float) finalValue/100;
//        System.out.printf("%.2f",res);
//        System.out.println();
        System.out.printf("%d",finalValue/100);
        System.out.print(".");
        if(finalValue%100 == 0){
            System.out.print("00");
            System.out.println();
        }
        else if(finalValue%100 < 10){
            System.out.printf("0%d",finalValue%100);
            System.out.println();
        }else{
            System.out.printf("%d",finalValue%100);
            System.out.println();
        }
//        System.out.printf("%d",finalValue%100);
//        System.out.println();

    }
}
