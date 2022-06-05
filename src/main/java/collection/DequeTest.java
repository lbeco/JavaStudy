package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new LinkedList<>();
        stack.push(1);
        stack.add(3);
        stack.forEach(System.out::println);
        System.out.println(stack.peek());

        stack.pollLast();
        stack.addLast(9);


        stack.forEach(System.out::println);
        System.out.println(stack.stream().count());
        Iterator<Integer> i = stack.descendingIterator();
        System.out.println(i.next());
    }
}
