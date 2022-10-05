package train;

import collection.DequeTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class WaitNotifyTest {
    Object o;
    Deque<Integer> dq ;
    int limit = 10;
    public static void main(String[] args) {
        WaitNotifyTest w = new WaitNotifyTest();
        w.start();
    }

    public void start(){
        o = new Object();
        dq = new ArrayDeque<>();
        Producer p =new Producer();
        Consumer c = new Consumer();
        p.start();
        c.start();
    }
    class Producer extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
//                try{
//                    Thread.sleep(3000);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                synchronized (o){
                    if(dq.size()>limit){
                        try {
                            sleep(100);
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("push"+i);
                    dq.addFirst(i);
                    o.notifyAll();


                }
            }

        }
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                synchronized (o){
                    if(dq.size()==0){
                        try {
                            sleep(100);
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(dq.pollLast());
                    o.notifyAll();

                }
            }

        }
    }
}
