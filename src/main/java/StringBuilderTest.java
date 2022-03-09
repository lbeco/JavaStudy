public class StringBuilderTest {

    public static void main(String[] args) {

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();   //获取开始时间
        StringCycle();
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("String 程序运行时间： " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();   //获取开始时间
        StringBufferCycle();
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("StringBuffer 程序运行时间： " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();   //获取开始时间
        StringBuilderCycle();
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("StringBuilder 程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static void StringBuilderCycle() {
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10000; j++) {
                sb = sb.append("1");
            }
        }
    }

    private static void StringCycle() {
        for (int i = 0; i < 100; i++) {
            String sb = new String();
            for (int j = 0; j < 10000; j++) {
                sb = sb + "1";
            }

        }
    }

    private static void StringBufferCycle() {
        for (int i = 0; i < 100; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 10000; j++) {
                sb = sb.append("1");
            }
        }
    }
}
