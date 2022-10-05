package collection;

import java.util.concurrent.LinkedBlockingDeque;

public class BlockedQueueTest {
    LinkedBlockingDeque<Integer> dq;
    public static void main(String[] args) {
        BlockedQueueTest blockedQueueTest = new BlockedQueueTest();
        blockedQueueTest.run();

    }
    public void run(){
        dq = new LinkedBlockingDeque<>();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();

    }



    public class Producer extends Thread{
        @Override
        public void run() {
            int value = 0;
            while(true){
                try {
                    dq.putFirst(value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                value ++;
            }

        }
    }

    public class Consumer extends Thread{
        @Override
        public void run() {
            int value = 0;
            while(true){
                try {
                    int res = dq.takeFirst();
                    System.out.println(res);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
