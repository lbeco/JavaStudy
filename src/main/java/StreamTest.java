import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hollis", "HollisChuang", "hollis", "Hello", "HelloWorld", "Hollis");
        List<Integer> strings2 = strings.stream()
                // .filter(string -> string.length()<= 6) // 过滤掉符合条件的
                .map(String::length) // 映射
                .sorted() // 默认递增
                // .sorted(Comparator.reverseOrder()) // 倒排
                .distinct() // 去重
                .limit(3) // 前三个
                .collect(Collectors.toList());


        int largerst = strings.stream()
                .filter(string -> string.startsWith("Ho"))
                .mapToInt(String::length)
                .max()
                .orElse(0);
        strings2.forEach(System.out::println);
        // System.out.println(largerst);
    }
}
