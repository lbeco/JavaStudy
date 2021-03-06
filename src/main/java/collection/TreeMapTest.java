package collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,Integer> tm = new TreeMap<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        tm.put(1,2);
        tm.put(3,4);
        tm.put(2,1);
        tm.put(9,12);
        tm.get(3);
        int flag = tm.ceilingEntry(6).getValue();

        System.out.println(flag);

        System.out.println(tm.headMap(100));
        System.out.println(tm.tailMap(0));
        System.out.println(tm.lastEntry().getValue());


    }
}
