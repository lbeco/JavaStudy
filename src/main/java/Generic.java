import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Generic {


    public static void main(String[] args) {
        List<Integer> m = new ArrayList<Integer>();
        int[] a = new int[]{3,2,3,4};
        m.add(1);
        m.add(2);
        m.size();
        Integer[] iList = m.toArray(new Integer[0]);
        Iterator<Integer> it = m.iterator();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        m = Arrays.asList(1,2,3,4);
        m.forEach(System.out::println);

        // m.stream().forEach(num-> System.out.println(num));

        Arrays.sort(iList, (c, b) -> b- c);
        int[] d = Arrays.copyOfRange(a,1,2);
        int[] e = d.clone();



    }
}
