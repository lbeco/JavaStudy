package train;

public class Print01Train2 {

    public static volatile boolean flag;

    public static void main(String[] args) {

        Print01Train2 print01Train2 = new Print01Train2();
        print01Train2.runPrint01();
    }
    public void  runPrint01(){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();

    }

    class Thread1 extends Thread {
        public void run() {
            int i = 0;
            while(i<10) {
                if (flag) {
                    System.out.println("1");
                    flag = false;
                    i++;
                }
            }
        }

    }

    class Thread2 extends Thread {
        public void run() {
            int i = 0;
            while(i<10) {
                if (!flag) {
                    System.out.println("0");
                    flag = true;
                    i++;
                }
            }
        }
    }
}
