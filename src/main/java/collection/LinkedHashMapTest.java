package collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> lru = new LinkedHashMap<>(4, (float)0.75,true);

        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.get(1);


        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);

        Iterator<Map.Entry<Integer, Integer>> iter = lru.entrySet().iterator();
        while(iter.hasNext()){
            Integer i = iter.next().getValue();
            System.out.println(i);

        }

    }
}
