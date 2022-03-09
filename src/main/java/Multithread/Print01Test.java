package Multithread;

public class Print01Test {
    private static volatile Integer flag;
    public static void main(String[] args) {
        flag = 11000;
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
            if(flag == 11000){
                System.out.println("0");
                flag = 11001;
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
            if(flag == 11001){
                System.out.println("1");
                flag = 11000;
                i++;
            }
        }

    }
}
