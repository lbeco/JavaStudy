import java.util.ArrayList;
import java.util.List;

public class Tree {
    class Node {
        public Node left;
        public Node right;
        public int num;

        Node(Node left, Node right, int num) {
            this.left = left;
            this.right = right;
            this.num = num;
        }

        Node(int num) {
            this.left = null;
            this.right = null;
            this.num = num;
        }
    }

    public List<Integer> solve() {
        List<Integer> res = new ArrayList<>();
        Node root = new Node(5);
        Node left1 = new Node(3);
        Node right1 = new Node(7);
        root.left = left1;
        root.right = right1;
        Node left2 = new Node(1);
        Node right2 = new Node(4);
        left1.left = left2;
        left1.right = right2;

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (nodeList.size() != 0) {
            List<Node> newNodeList = new ArrayList<>();
            for (Node n : nodeList) {
                res.add(n.num);
                if (n.left != null) {
                    newNodeList.add(n.left);
                }
                if (n.right != null) {
                    newNodeList.add(n.right);
                }

            }
            nodeList = new ArrayList<>();
            for (Node n : newNodeList) {
                nodeList.add(n);
            }
        }
        return res;

    }

    public Node decode(List<Integer> res) {
        if(res.size()==0){
            return null;
        }

        int index = 1;
        int count = 2;
        int len = res.size();
        Node root = new Node(res.get(0));

        List<Node> last= new ArrayList<>();
        last.add(root);

        while(index<len){
            List<Node> next= new ArrayList<>();
            for(int i=0;i<count;i++){
                if(i+index>=len){
                    break;
                }
                Node n = new Node(res.get(i+index));
                Node p = last.get(i/2);
                if(i%2==0){
                    p.left=n;
                }else{
                    p.right=n;
                }
                next.add(n);
                index++;
            }
            count*=2;
            last = new ArrayList<>();
            last.addAll(next);
        }
        return root;

    }

    public static void main(String[] args) {

        Tree t = new Tree();
        List<Integer> res = t.solve();
        Node n = t.decode(res);


        return;


    }


}


//            5
//        3       7
//    1     4   6     9
//
//1345679
//
//5314769
//
//5 37 1469

