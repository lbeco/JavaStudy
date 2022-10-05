package jd;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.math.BigInteger;
import java.util.Scanner;
import java.util.*;
public class JD {
    BigInteger res = new BigInteger("0");
    TreeMap<BigInteger,String> map = new TreeMap<>(Comparator.reverseOrder());
    public static void main(String[] args) {
        JD main = new JD();
        main.run();

    }

    public void run(){
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();

        String[] possible = new String[6];
        StringBuffer sb = new StringBuffer();
        possible[0] = "";
        possible[1] = "9";
        possible[2] = "19";
        possible[3] = "113";
        possible[4] = "1919";
        possible[5] = "1113";
        getMap();

        long sum2=0;
        long sum3=0;
        long sum5=0;
        if(n.compareTo(new BigInteger("0")) == 0){
            System.out.println("");
            return;
        }
        for(BigInteger l : map.keySet()){
            while(n.mod(l).compareTo(new BigInteger("0")) == 0){
                sb.append(map.get(l));
                n = n.divide(l);
            }
        }


        if(n.compareTo(new BigInteger("1")) != 0){
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }

    public String check(long n){
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            return "";
        }
    }
    public void getMap(){
        StringBuffer sb = new StringBuffer();
        sb.append( "13");
        for (int i = 0; i < 33; i++) {

            res = new BigInteger("0");

            search(sb.toString(),0);
            map.put(res,sb.toString());
            sb.insert(0,"1");
        }

    }
    public  int search(String s,int i){
        if(i >= s.length()){
            res = res.add(new BigInteger("1"));
            return 0;
        }
        if(i+1<=s.length()){
            search(s,i+1);
        }
        if(i+2<=s.length()){
            search(s,i+2);
        }
        return 0;
    }
}