import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringTest {

    public static void main(String[] args) {
        String a = "1,2,3";
        char[] aCharArr = a.toCharArray();
        String b2 = String.copyValueOf(aCharArr,0,1);
        String b = String.copyValueOf(aCharArr);
        System.out.println(b2);
        String c = b.concat(",");
        System.out.println(c);
        System.out.println(b.contains("123"));
        String[] res = a.split(",");
        List<String> list = new ArrayList<>();
        list.add("123");
        Set<String> set = new HashSet<>();
        String s1 = new String("123");
        String s2 = new String("123");
        String s3 = s1+s2;
        System.out.println(s3);

    }
}
