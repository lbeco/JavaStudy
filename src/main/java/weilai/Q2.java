package weilai;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        Deque<String> stack = new ArrayDeque<String>();
        char[] ch = s.toCharArray();
        String line = "";
        int state = 0;
        for(int i=0;i<ch.length;i++){
            if(state == 0){
                if(ch[i] == '<'){
                    state = 1;
                }else{
                    System.out.println("NO");
                    return;
                }
            }else if(state == 1){
                if(ch[i] == '/'){
                    state = 2;
                }else if (ch[i] <= 'z' && ch[i] >= 'a'){
                    line = line + ch[i];
                }else if (ch[i] == '>'){
                    if(line.length() == 0){
                        System.out.println("NO");
                        return;
                    }
                    stack.add(line);
                    line = "";
                    state = 0;
                }else{
                    System.out.println("NO");
                    return;
                }
            }else if (state == 2){
                if (ch[i] <= 'z' && ch[i] >= 'a'){
                    line = line + ch[i];
                }else if (ch[i] == '>'){
                    if(line.length() == 0){
                        System.out.println("NO");
                        return;
                    }
                    if(stack.size() ==0){
                        System.out.println("NO");
                        return;
                    }
                    String prev = stack.peekLast();
                    if(prev.equals(line)){
                        stack.pollLast();
                    }else{
                        System.out.println("NO");
                        return;
                    }
                    line = "";
                    state = 0;
                }else{
                    System.out.println("NO");
                    return;
                }
            }

        }
        if(state != 0){
            System.out.println("NO");
            return;
        }
        if(stack.size()!=0){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");


    }
}
