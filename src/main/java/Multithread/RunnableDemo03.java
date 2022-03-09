package Multithread;

import java.util.concurrent.atomic.AtomicInteger;

/*
    原子操作
 */
public class RunnableDemo03 {
    public static void main(String[] args){
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int x = 0;x < 10; x++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{
    // private int i = 0;
    AtomicInteger i = new AtomicInteger();
    public int getI(){
        // return i++;
        return i.getAndIncrement();

    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}

/*
i++:
0
0
1
0
0
0
2
4
4
3

 */

/*
AtomicInteger:
0
1
2
8
9
7
6
3
5
4
 */