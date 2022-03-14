package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZhongXu {
    public static void main(String[] args) {
        Node root = Tree.getTree();
        List<Integer> res = new ArrayList<>();

        Deque<Node> dq =  new ArrayDeque<>();

        Node cur = root;
        while(cur!=null || !dq.isEmpty()){
            if(cur!=null){
                dq.push(cur);
                cur = cur.left;
            }else{
                cur = dq.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        res.forEach(System.out::println);

    }
}
