package Multithread;

import java.util.concurrent.Semaphore;

public class Print01Semaphore {
    private static int order = 0;
    private static int n = 10;
    private static Semaphore[] semaphores = new Semaphore[Print01Semaphore.n];

    public static void main(String[] args) throws InterruptedException{

        for(int i=0; i<Print01Semaphore.n; i++){
            semaphores[i] = new Semaphore(1);
            semaphores[i].acquire();
            new Thread(new R(i)).start();
        }
        semaphores[0].release();
    }


    static class R implements Runnable{
        private int id;
        public R(int id){this.id = id;}

        @Override
        public void run() {
            while(true){
                try{
                    Print01Semaphore.semaphores[this.id].acquire();
                } catch (InterruptedException ignore){}

                System.out.println(this.id);
                Print01Semaphore.order = (Print01Semaphore.order+1) % Print01Semaphore.n;

                Print01Semaphore.semaphores[Print01Semaphore.order].release();
            }
        }
    }
}
