package baidu;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class Baidu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        int forV = 0;
        int ifV = 0;
        int sum =0;
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String s = in.nextLine();
            if (s.contains("for")){
                forV+=1;
            }
            if (s.contains("if")){
                ifV+=1;
            }
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '{'){
                    sum++;
                }
            }
            System.out.println(sum);
        }


        System.out.println(2);
    }
}