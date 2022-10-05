package xiecheng;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.math.BigInteger;
import java.util.Scanner;
public class Xiecheng2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nIn = in.nextInt();
        long n = nIn;
        BigInteger b = new BigInteger(String.valueOf(n));
        long total = n * n;
        BigInteger res ;
        if(n == 1){
            res = new BigInteger(String.valueOf(0));
        }

        else if(n == 2){
            res = new BigInteger(String.valueOf(20));
//         }else if (n == 3){
//             res = 134;
        }else{
            res = new BigInteger(String.valueOf(20));
            // long sec = (((( ((n-2) * 4L)  % 1000000007 ) * ((5 + ((n-1) % 1000000007)  * 4L) % 1000000007)) % 1000000007) / 2 * 3) % 1000000007;
            // System.out.println(sec);
            // long add = ( ( ( ( ( ((n-1)* 4L + 1)  % 1000000007 ) + (long) n *n  % 1000000007 ) * ((long) n *n  % 1000000007 -(n-1)* 4L % 1000000007 )) % 1000000007) / 2) * 4 % 1000000007;

            BigInteger sec = (b.subtract(BigInteger.valueOf(2))).multiply(BigInteger.valueOf(4))
                    .multiply(BigInteger.valueOf(5).add((b.subtract(BigInteger.valueOf(1)) )
                            .multiply(BigInteger.valueOf(4)))).divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(3));
            // System.out.println(sec);
            // long add =
            // ( ( ( ( ( ((n-1)* 4L + 1)  % 1000000007 ) + (long) n *n  % 1000000007 ) * ((long) n *n  % 1000000007 -(n-1)* 4L % 1000000007 )) % 1000000007) / 2) * 4 % 1000000007;
            BigInteger add = b.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(4)).add(BigInteger.valueOf(1))
                    .add(b.multiply(b))   .multiply(b.multiply(b).subtract(b.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(4)))).divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(4));
            // System.out.println(add);
            res = (res.add(sec)) ;
            res = (res.add(add));
            res = res.mod(BigInteger.valueOf(1000000007));
        }


        System.out.println(res.toString());
    }
}