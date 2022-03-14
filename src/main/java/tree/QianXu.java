package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class QianXu {

    public static void main(String[] args) {
        Node root = Tree.getTree();
        List<Integer> res = new ArrayList<>();

        Deque<Node> dq =  new ArrayDeque<>();

        dq.push(root);
        while(!dq.isEmpty()){
            Node node = dq.pop();
            res.add(node.val);
            if(node.right!=null){
                dq.push(node.right);
            }
            if(node.left!=null) {
                dq.push(node.left);
            }


        }
        res.forEach(System.out::println);

    }

}
