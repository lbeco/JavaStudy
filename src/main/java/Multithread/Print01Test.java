package Multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Print01Test {

    //这么操作永远都不行，因为Integer赋值的时候会新建一个Integer
    private static volatile Integer flag= 0;
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1(flag);
        Thread2 thread2 = new Thread2(flag);
        thread1.start();
        thread2.start();
    }


}

class Thread1 extends Thread{
    private Integer flag;
    public Thread1(Integer flag){
        this.flag = flag;
    }
    @Override
    public void run() {
        for(int i=0;i<100;){
            if(flag == 1){
                System.out.println("0");
                flag=0;
                i++;
            }
        }

    }
}

class Thread2 extends Thread{
    private Integer flag;
    public Thread2(Integer flag){
        this.flag = flag;
    }
    @Override
    public void run() {
        for(int i=0;i<100;){
            if(flag==0){
                System.out.println("1");
                flag=1;
                i++;
            }
        }

    }
}
