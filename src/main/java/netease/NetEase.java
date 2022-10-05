package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetEase {
    int[] gotFlag;

    public void get(int index,List<List<Integer>> next){
        if( gotFlag[index]==1)return;
        gotFlag[index]=1;
        List<Integer> nextKey = next.get(index);
        for(int key : nextKey){
            get(key,next);
        }

    }

    public void run(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String input = s.substring(1,s.length()-1);
        int flag = 0;
        int prev = 0;
        List<List<Integer>> next = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);

            if(c == '['){
                flag=1;
                prev = i;
            }
            if(c == ']'){
                flag = 0;
                String sub = input.substring(prev+1,i);
                String[] num = sub.split(",");
                List<Integer> nextList = new ArrayList<>();
                for(String numS : num){
                    if(numS.length()>0){
                        nextList.add(Integer.valueOf(numS));
                    }

                }
                next.add(nextList);

            }
        }
        gotFlag = new int[next.size()];
        get(0,next);
        boolean res = true;
        for(int i:gotFlag){
            if(i==0){
                System.out.println("false");
                return ;
            }
        }
        System.out.println("true");
        return;

    }

    public static void main(String[] args) {
        NetEase netEase = new NetEase();
        netEase.run();


    }
}
