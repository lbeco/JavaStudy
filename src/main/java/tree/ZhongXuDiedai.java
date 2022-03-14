package tree;

import java.util.*;

public class ZhongXuDiedai {
    public static void main(String[] args) {
        Node root = Tree.getTree();
        List<Integer> res = new ArrayList<>();
        Stack<Node> dq =  new Stack<>(); // stack可以有null节点

        dq.push(root);
        while(!dq.isEmpty()){
            Node cur = dq.peek();
            if(cur!=null){
                dq.pop();
                if(cur.right!=null) {
                    dq.push(cur.right);
                }
                dq.push(cur);
                dq.push(null);
                if(cur.left!=null) {
                    dq.push(cur.left);
                }
            }else{
                dq.pop();
                cur = dq.pop();
                res.add(cur.val);
            }
        }
        res.forEach(System.out::println);

    }
}
