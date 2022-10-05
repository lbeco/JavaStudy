package meituan.exam2;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] node = new int[3][2];
        int[] dist = new int[3];
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });


        for(int i =0;i<3;i++){
            node[i][0] = scanner.nextInt();
            node[i][1] = scanner.nextInt();
        }
        for(int i =0;i<3;i++){
            dist[i] = scanner.nextInt();

        }
        // int[][] map = new int[n+1][n+1];

        for(int nodeIndex=0;nodeIndex<3;nodeIndex++){
            int[] thisNode = node[nodeIndex];
            int d = dist[nodeIndex];
            int x = thisNode[0]+d;
            int y = thisNode[1];
            if(d==0){
                if(0<x && x<=n && y>0 && y<=n){
                    int key = x*100000+y;
                    map.put(key,map.getOrDefault(key,0)+1);

                    if(map.getOrDefault(key,0)==3){
                        pq.add(new int[]{x,y});
                    }
                }
                continue;
            }
            for(int i=0;i<d;i++){
                if(0<x && x<=n && y>0 && y<=n){
                    int key = x*100000+y;
                    map.put(key,map.getOrDefault(key,0)+1);

                    if(map.getOrDefault(key,0)==3){
                        pq.add(new int[]{x,y});
                    }

                }
                x--;
                y++;
            }
            for(int i=0;i<d;i++){
                if(0<x && x<=n && y>0 && y<=n){
                    int key = x*100000+y;
                    map.put(key,map.getOrDefault(key,0)+1);

                    if(map.getOrDefault(key,0)==3){
                        pq.add(new int[]{x,y});
                    }

                }
                x--;
                y--;
            }
            for(int i=0;i<d;i++){
                if(0<x && x<=n && y>0 && y<=n){
                    int key = x*100000+y;
                    map.put(key,map.getOrDefault(key,0)+1);

                    if(map.getOrDefault(key,0)==3){
                        pq.add(new int[]{x,y});
                    }

                }
                x++;
                y--;
            }

            for(int i=0;i<d;i++){
                if(0<x && x<=n && y>0 && y<=n){
                    int key = x*100000+y;
                    map.put(key,map.getOrDefault(key,0)+1);

                    if(map.getOrDefault(key,0)==3){
                        pq.add(new int[]{x,y});
                    }

                }
                x++;
                y++;
            }

        }
        // if(pq.size()==0){
        //   System.out.print(0);
        //   System.out.print(" ");
        //   System.out.println(1);
        // }else{
        int[] result = pq.peek();
        assert result != null;
        System.out.print(result[0]);
        System.out.print(" ");
        System.out.println(result[1]);
        // }


    }
}