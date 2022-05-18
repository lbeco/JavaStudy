package ali;

import java.util.*;

public class Solution2 {
    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);
    }
    static int[] money = new int[12];

    static String[] sList = new String[]{"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        for (int j = 0; j < 12; j++) {
            String a = in.nextLine();
            String[] cOfM = a.split(":");
            int MIndex = map.get(cOfM[0]);
            MIndex--;
            int record = Integer.parseInt(cOfM[1]);
            String b = in.nextLine();
            String[] recordArr = b.split(" ");
            for(String s : recordArr){
                String[] singleRecord = s.split(":");
                String[] to = singleRecord[1].split("\\.");
                int t = Integer.parseInt(to[0]);
                int x = Integer.parseInt(to[1]);
                if(t>=0){
                    money[MIndex] += t*100 + x;
                }else{
                    money[MIndex] += t*100 - x;
                }
                //money[MIndex] += (int)(Double.parseDouble(singleRecord[1]) * 100);
            }
        }


        for (int i = 0; i < 12; i++) {
            System.out.print(sList[i]+":");
            if (money[i] < 0){
                if((money[i]%100)/10 == 0){
                    System.out.format("%d.0%d",money[i]/100,money[i]%100).println();
                }else{
                    System.out.format("%d.%d",money[i]/100,money[i]%100).println();
                }

            }else{
                System.out.print("+");
                if((money[i]%100)/10 == 0){
                    System.out.format("%d.0%d",money[i]/100,money[i]%100).println();
                }else{
                    System.out.format("%d.%d",money[i]/100,money[i]%100).println();
                }
            }

        }
        int minIndex = 0;
        int maxIndex = 0;
        int minMonth = 1000000;
        int maxMonth = -1000000;
        for (int i = 0; i < 12; i++) {
            if(money[i] > maxMonth){
                maxMonth = money[i];
                maxIndex = i;
            }
            if(money[i] < minMonth){
                minMonth = money[i];
                minIndex = i;
            }
        }
        System.out.print(sList[minIndex] + " ");
        System.out.println(sList[maxIndex]);



    }


}
