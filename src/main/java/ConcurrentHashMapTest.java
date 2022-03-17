import lombok.SneakyThrows;
import sun.nio.ch.ThreadPool;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        ExecutorService es = new ThreadPoolExecutor(4,4,
                (long)100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));
        es.submit(new Thread1(map,0));
        es.submit(new Thread1(map,10));
        es.submit(new Thread1(map,20));
        System.out.println("finished");
        es.shutdown();
    }


}

class Thread1 extends Thread{
    Map<Integer,Integer> map;
    int count;
    private final Random random = new Random();
    Thread1(Map map,int count){
        this.map = map;
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=count;i<count+8;i++){
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (Exception e){

            }
            map.put(i,i/8);
        }

    }
}
