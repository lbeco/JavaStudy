package mi;



import java.io.*;
import java.util.*;

public class Mi2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 0;
        for(int i=1;i<=s.length();i++){
            dp[i][0] = dp[i-1][0]+1;
        }
        for(int i=1;i<=t.length();i++){
            dp[0][i] = dp[0][i-1]+1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1) != t.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }

            }
        }
        System.out.println(dp[s.length()][t.length()]);


    }
}
