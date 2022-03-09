package Multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    volatile example
 */
public class ThreadTest {
    private int i = 0;
    private Thread thread1, thread2, thread3;
    private volatile int flag = 0;

    public void runThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Thread1()));
        executorService.submit(new Thread(new Thread2()));
        executorService.submit(new Thread(new Thread3()));

    }

    public class Thread1 implements Runnable {

        public void run() {
            while (i < 100) {
                if (flag == 0) {
                    System.out.println("t1=" + i);
                    i++;
                    flag = 1;
                }
            }
        }

    }

    public class Thread2 implements Runnable {

        public void run() {

            while (i < 100) {
                if (flag == 1) {
                    System.out.println("t2=" + i);
                    i++;
                    flag = 2;
                }
            }
        }

    }

    public class Thread3 implements Runnable {

        public void run() {

            while (i < 100) {
                if (flag == 2) {
                    System.out.println("t3=" + i);
                    i++;
                    flag = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.runThread();
    }
}