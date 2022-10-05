package mi;

import java.io.*;
import java.util.*;

public class Mi1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0]-o2[0];
            }
        });

        while(in.hasNextInt()){
            int[] data = new int[2];
            data[0] = in.nextInt();
            data[1] = in.nextInt();
            pq.add(data);
        }
        int res = 0;
        while(pq.size()>0){
            int[] head = pq.poll();
            while(pq.peek()[0] < head[1]){
                int[] next = pq.poll();
                head[1] = next[1];
            }
            res += (head[1]-head[0]);
        }
        System.out.println(res);


    }
}
