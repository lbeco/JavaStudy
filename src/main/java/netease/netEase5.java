package netease;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class netEase5 {
    class Node{
        List<Integer> child;
        int val;
        Node(){};
        Node(int v){
            val = v;
            child = new ArrayList<>();
        }
    }
    Node[] list;
    int res;
    public void run(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        list = new Node[n];
        res = 0;
        for(int i=0;i<n;i++){
            list[i] = new Node(in.nextInt());
        }
        for(int i=0;i<n-1;i++){
            int r = in.nextInt();
            int c = in.nextInt();
            list[r-1].child.add(c-1);
        }
        dfs(0);
        System.out.println(res);


    }

    public Long getNum(long v){
        Set<Integer> source = new HashSet<>();
        source.add(1);

        for(int i=2;i<=v;i++){
            if(v % i ==0){
                source.add(i);
            }
        }
        return (long)source.size();
    }

    public Long dfs(int r){
        long val = list[r].val;
        Long source = getNum(list[r].val);

        for(int n : list[r].child){
            val = val * dfs(n);
        }
        res += getNum(val);


        return val;
    }
    public static void main(String[] args) {
        netEase5 main = new netEase5();
        main.run();

    }
}