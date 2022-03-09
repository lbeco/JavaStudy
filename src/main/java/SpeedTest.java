public class SpeedTest {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间

        test1();  //测试的代码段

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void test1() {
        Integer val = 1;
        for (int i = 0; i < 100000000; i++) {

            val = val <<2 ;
        }
    }
}
