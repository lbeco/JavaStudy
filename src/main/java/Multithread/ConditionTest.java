package Multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    static Condition c;
    static ReentrantLock rw;

    class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                rw.lock();

                System.out.println(i);
                c.signal();
                try {
                    c.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                rw.unlock();
            }
        }
    }

    public void test() {
        rw = new ReentrantLock();

        c = rw.newCondition();
        ExecutorService tp = new ThreadPoolExecutor(5, 5, 1000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        tp.submit(new Thread1());
        tp.submit(new Thread1());

    }


    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        conditionTest.test();


    }
}
