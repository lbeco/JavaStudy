package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n + 1];
        List<Integer>[] next = new List[n + 1];
        int[] prevCount = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            next[i] = new ArrayList<>();
        }

        int[]  res = new int[n+1];

        List<Integer> startup = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            list[i + 1] = time;

            int count = scanner.nextInt();
            prevCount[i+1] += count;
            for (int j = 0; j < count; j++) {
                int prev = scanner.nextInt();
                next[prev].add(i + 1);
            }
            if (count == 0) {
                startup.add(i + 1);
            }
        }

        boolean[] done = new boolean[n + 1];
        int totalTime = 0;
        while (true) {
            if(startup.isEmpty()){
                break;
            }
            List<Integer> addList = new ArrayList<>();
            List<Integer> dropList = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int clazz : startup) {
                min = Math.min(min, list[clazz]);
            }
            totalTime += min;

            for (int clazz : startup) {
                list[clazz] -= min;
                if (list[clazz] == 0) {
                    res[clazz] = totalTime;
                    done[clazz] = true;
                    dropList.add(clazz);

                    for (int i : next[clazz]) {
                        prevCount[i]--;
                        if(prevCount[i] == 0){
                            addList.add(i);
                        }
                    }
                }
            }
            startup.addAll(addList);
            startup.removeAll(dropList);


        }
        for (int i = 1; i < n+1; i++) {
            System.out.print(res[i] + " ");
        }




    }
}
