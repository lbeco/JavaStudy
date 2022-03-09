import java.util.*;

public class PriorityQueueTest {


    public static void main(String[] args) {


        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        LinkedHashMap linkedHashMap = new LinkedHashMap(10,(float)0.75,true);

        p.add(1);
        p.add(2);
        p.add(5);
        p.add(3);

        System.out.println(p.poll()); // poll弹出来
        System.out.println(p.poll());
        System.out.println(p.size());
        System.out.println(p.peek());
        System.out.println(p.peek()); // peek取最顶部


        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.add(3);
        System.out.println(deque.peek());
        System.out.println(deque.pop());
        Map<Integer,Integer> map = new LinkedHashMap<>(10,0.75f,true);

    }
}
