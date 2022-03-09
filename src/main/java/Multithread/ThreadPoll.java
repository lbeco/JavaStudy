package Multithread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThread extends Thread {
    private int i;
    private final Random random = new Random();

    public MyThread(int in) {
        this.i = in;
    }

    public void run() {
        System.out.println("      " + currentThread().getName() + "线程启动：" + i);
        try {
            // sleep(random.nextInt(1000));
            sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName() + "正在打印：" + i);
    }
}

public class ThreadPoll {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyThread(i));
        }
        executorService.shutdown();

    }
}