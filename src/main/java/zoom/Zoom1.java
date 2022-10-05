package zoom;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
import java.util.*;
public class Zoom1 {
    int res;
    class ZoomNode{
        int color;
        ZoomNode left;
        ZoomNode right;
        ZoomNode(){

        }
        ZoomNode(int color){
            this.color = color;
        }
    }

    void run(){
        res=0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String rb = in.nextLine();
        char[] cArr = rb.toCharArray();
        int[] color = new int[n];

        for(int i=0;i<cArr.length;i++){
            char c = cArr[i];
            if(c == 'R')color[i] = 1;
            else color[i] = 0;
        }
        List<int[]> link = new ArrayList<>();

        for(int i=0;i<n-1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            link.add(new int[]{a,b});
        }
        Map<Integer,ZoomNode> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(1);
        map.put(1,new ZoomNode(color[0]));
        while(dq.size()>0){
            int v = dq.peekLast();
            List<Integer> related = new ArrayList<>();
            for(int i=0;i<link.size();i++){
                int[] val = link.get(i);
                if(val[0] == v || val[1] == v ){
                    related.add(i);
                }
            }
            for(int i=0;i<related.size();i++){
                int[] val = link.get(related.get(i));
                int index = related.get(i);
                if(val[0] == v){
                    if(map.get(v).left == null){
                        map.get(v).left = new ZoomNode(color[val[1]-1]);
                        map.put(val[1],map.get(v).left);
                        dq.addFirst(val[1]);
                    }else{
                        map.get(v).right = new ZoomNode(color[val[1]-1]);
                        map.put(val[1],map.get(v).right);
                        dq.addFirst(val[1]);
                    }
                }else if (val[1] == v){
                    if(map.get(v).left == null){
                        map.get(v).left = new ZoomNode(color[val[0]-1]);
                        map.put(val[0],map.get(v).left);
                        dq.addFirst(val[0]);
                    }else{
                        map.get(v).right = new ZoomNode(color[val[0]-1]);
                        map.put(val[0],map.get(v).right);
                        dq.addFirst(val[0]);
                    }
                }
            }

            dq.pollLast();
            List<int[]> newLink = new ArrayList<>();
            for(int i=0;i<link.size();i++){
                if(!related.contains(i)){
                    newLink.add(link.get(i));
                }
            }
            link = new ArrayList<>(newLink);


        }

        ZoomNode curr = map.get(1);
        dfs(curr,0,0);

        System.out.println(res);
        return ;

    }

    public void dfs(ZoomNode root,int b, int r){
        if(root == null) return;
        if(root.color == 1){
            r++;
        }else{
            b++;
        }
        res += Math.abs(r-b);
        dfs(root.left,b,r);
        dfs(root.right,b,r);

    }
    public static void main(String[] args) {
        Zoom1 zoom1 = new Zoom1();
        zoom1.run();



        return ;
    }
}
/*
5
RBRBB
2 5
1 5
4 1
3 5
 */