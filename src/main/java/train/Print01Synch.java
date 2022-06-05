package train;

public class Print01Synch {
    private static volatile int order = 0;
    private Object obj = new Object();

    public static void main(String[] args) {
        Print01Synch print01Synch = new Print01Synch();
        print01Synch.runThreads();
    }

    public void runThreads(){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
    class Thread1 extends Thread {
        Thread1() {

        }

        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                synchronized (obj) {
                    if (order == 0) {
                        System.out.println("0");
                        order = 1;
                        i++;

                    }
                }

            }
        }
    }

    class Thread2 extends Thread {
        Thread2() {

        }

        @Override
        public void run() {
            for (int i = 0; i < 100; ) {
                synchronized (obj) {
                    if (order == 1) {
                        System.out.println("1");
                        order = 0;
                        i++;

                    }
                }

            }
        }
    }
}
