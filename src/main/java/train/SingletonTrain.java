package train;

public class SingletonTrain {
    private static SingletonTrain singletonTrain;
    private static Object obj = new Object();

    public static SingletonTrain getSingletonTrain() {
        if (singletonTrain == null) {
            synchronized (obj) {
                if (singletonTrain == null) {
                    singletonTrain = new SingletonTrain();

                }
            }
        }
        return singletonTrain;
    }

}

