package train;

public class Print01WaitTest {
    static Object obj = new Object();
    public static  boolean flag;
    public static void main(String[] args) {
        Print01WaitTest print01WaitTest = new Print01WaitTest();
        print01WaitTest.run();
    }
    public void run(){
        Thread thread1 = new thread1();
        Thread thread2 = new thread2();
        thread1.start();
        thread2.start();

    }

    class thread1 extends  Thread{
        public void run(){
            for (int i = 0; i < 100; i++) {
                synchronized (obj){
                    if(!flag){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(0);
                    flag = false;
                    obj.notifyAll();

                }
            }

        }
    }
    class thread2 extends  Thread{
        public void run(){
            for (int i = 0; i < 100; i++) {
                synchronized (obj){
                    if(flag){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    flag = true;
                    System.out.println(1);
                    obj.notifyAll();

                }
            }

        }
    }


}
