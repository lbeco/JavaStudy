package train;

import lombok.SneakyThrows;

public class Print01train {
    private static volatile  boolean flag ;

    public static void main(String[] args) {
        Print01train print01train = new Print01train();
        print01train.runThreads();

    }
    public void runThreads(){
        flag = false;
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
    class Thread1 extends Thread{
        Thread1(){

        }
        @Override
        public void run() {
            for(int i=0;i<100;){
                //System.out.println("thread1 test"+flag);
                if(flag){
                    System.out.println("0");

                    flag = false;
                    i++;

                }
            }
        }
    }

    class Thread2 extends Thread{
        Thread2(){

        }
        @Override
        public void run() {
            for(int i=0;i<100;){
                //System.out.println("thread2 test"+flag);
                if(!flag){
                    System.out.println("1");
                    flag = true;
                    i++;

                }

            }
        }
    }
}
