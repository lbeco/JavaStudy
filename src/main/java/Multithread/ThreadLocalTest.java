package Multithread;

public class ThreadLocalTest {
    ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        intLocal.set((int) Thread.currentThread().getId());
        
        stringLocal.set(Thread.currentThread().getName());
    }

    public void removeThreadLocal(){
        intLocal.remove();
        stringLocal.remove();
    }

    public Integer getInt() {
        return intLocal.get();
    }
    public String getString() {
        return stringLocal.get();
    }
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getInt());
        System.out.println(test.getString());


        //这里写了对main没有影响，可见线程独有
        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getInt());
                System.out.println(test.getString());
                test.removeThreadLocal();
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getInt());
        System.out.println(test.getString());
    }
}
