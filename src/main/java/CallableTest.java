import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;


class MyCallable implements Callable<Integer> {
    private int i;

    private final Random random = new Random();

    public MyCallable(int in) {
        this.i = in;
    }


    @Override
    public Integer call() throws Exception {
        sleep(500);
        return i;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> res= executorService.submit(new MyCallable(5));
        System.out.println(res.get());
        executorService.shutdown();
    }
}
