package Multithread;

import java.util.Random;

public class RunnableDemo02 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new ShareVariableThread();
            threads[i].setName(String.valueOf(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class ShareVariableThread extends Thread {
    private int count = 5;

    private boolean flag = false;

    private final Random random = new Random();

    public void run() {
        synchronized (this){
            count = count - 1;
            System.out.println("" + Thread.currentThread().getName() + ",count:" + count);
        }
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(!flag){
            flag = true;
            System.out.println(flag + " " + Thread.currentThread().getName());
        }
    }
}