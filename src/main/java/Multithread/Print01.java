package Multithread;

public class Print01 {

    private volatile boolean flag = false;

    public static void main(String[] args) {
        Print01 p  = new Print01();
        p.runPrint();
    }
    public void runPrint(){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    class Thread1 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;){
                if(flag){
                    System.out.println("0");
                    flag = false;
                    i++;
                }
            }

        }
    }

    class Thread2 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;){
                if(!flag){
                    System.out.println("1");
                    flag = true;
                    i++;
                }
            }
        }
    }
}
