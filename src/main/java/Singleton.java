/*
    饿汉
 */
public class Singleton {
    private Singleton() {}
    private static Singleton single = null;
    //静态工厂方法
    public static Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
}

/*
    饱汉
 */
class Singleton2 {
    private Singleton2() {}
    private static  Singleton2 single = new Singleton2();;

    public static Singleton2 getInstance() {

        return single;
    }
}

/*
    强行sync
 */
class Singleton3 {
    private Singleton3() {}
    private static Singleton3 single = null;
    //静态工厂方法
    public static synchronized Singleton3 getInstance() {
        if (single == null) {
            single = new Singleton3();
        }
        return single;
    }
}

/*
   双检锁大法
 */
class Singleton4 {
    private Singleton4() {}
    private static volatile Singleton4 single = null;
    //静态工厂方法
    public static Singleton4 getInstance() {
        if (single == null) {
            synchronized (Singleton4.class){
                if (single == null) {
                    single = new Singleton4();
                }
            }
        }
        return single;
    }
}

/*
   奇技淫巧 枚举
 */
enum Singleton5 {
    INSTANCE;
     public void whateverMethod() {
             }
 }


class Singleton6{
    private Singleton6(){}
    private static volatile Singleton6 single = null;

    public static Singleton6 getInstance(){
        if(single==null){
            synchronized (Singleton6.class){
                if(single==null){
                    single = new Singleton6();
                }
            }
        }
        return single;
    }
}

