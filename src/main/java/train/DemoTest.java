package train;

public class DemoTest {
    private  static  Integer count = 0;
    private  static  final Integer FULL = 10;
    private  static  String LOCK = "lock";
    public static void main(String[] args) {
        DemoTest testMain = new DemoTest();
        new Thread(testMain.new Producer()).start();
        new Thread(testMain.new Consumer()).start();
    }
    class Producer implements  Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while(count == FULL){//缓存空间满了
                        try{
                            LOCK.wait();//线程阻塞
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    count++;//生产者
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有"+count);
                    LOCK.notifyAll();//唤醒所有线程
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while(count == 0){
                        try{
                            LOCK.wait();
                        }catch (Exception e){
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有 "+count);
                    LOCK.notifyAll();//唤醒所有线程
                }
            }
        }
    }
}

