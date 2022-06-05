package Multithread;

import java.util.concurrent.*;

public class CountDownLatchTest {
    static CountDownLatch latch = new CountDownLatch(10);

    static class  Run implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("end!");
            latch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        ExecutorService tp = new ThreadPoolExecutor(5,5,1000, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
        for (int i = 0; i < 10; i++) {
            tp.submit(new Thread(new Run()));
        }
        latch.await();
        System.out.println("all end");
        tp.shutdown();
        return;

    }
}
