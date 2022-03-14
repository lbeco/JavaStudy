package Multithread;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    /**
     * volatile变量自增运算测试 *
     *
     * @author zzm
     */
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    private final static CountDownLatch latch = new CountDownLatch(THREADS_COUNT);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                    latch.countDown();
                }
            });
            threads[i].start();
        }
// 等待所有累加线程都结束
//        while (Thread.activeCount() > 2) { // 这玩意是靠监测所有线程的，不靠谱
//            System.out.println(Thread.activeCount() );
//            Thread.yield();
//        }
        latch.await(); // 还是countDownLatch好用
        System.out.println(race);
    }

}
