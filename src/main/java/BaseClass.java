import java.util.Arrays;

public class BaseClass {
    public static void main(String[] args) {
        Integer integer = 0;
        char[] charList = new char[]{'1','2','4'};
        Arrays.fill(charList,'3');
        String s = "127";
        // string转int
        integer = Integer.parseInt(s);
        System.out.println(integer);
        String s2 = String.copyValueOf(charList);
        System.out.println(s2);
        integer = Integer.valueOf(s,16);
        System.out.println(integer);
    }
}
