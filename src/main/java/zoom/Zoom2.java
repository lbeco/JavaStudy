package zoom;

import java.util.*;
import java.util.Scanner;
public class Zoom2 {
    public static void main(String[] args) {
        Map<String,String[]> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int i=0;i<q;i++){
            int op = in.nextInt();
            if(op==1){
                String name = in.next();
                int count = in.nextInt();
                // String[] sub = new String[];
                map.put(name,new String[]{});
            }
        }

    }
}