package Multithread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableDemo01 {
    public static void main(String[] args) {
        Runnable runnable = new ShareVariableRunnable();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(runnable, "thread:" + (i + 1));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class ShareVariableRunnable implements Runnable {
    private int count = 5;

    private boolean flag = false;

    Lock lock = new ReentrantLock();

    private final Random random = new Random();

    public void run() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        count = count - 1;
        System.out.println("" + Thread.currentThread().getName() + ",count:" + count);
        lock.unlock();



        if (!flag) {
            flag = true;
            System.out.println(flag + " " + Thread.currentThread().getName());
        }
    }
}