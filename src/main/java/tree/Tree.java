package tree;

public class Tree {
    public static Node getTree(){
        Node root = new Node(1);

        Node left = new Node(2);
        root.left = left;

        Node right = new Node(3);
        root.right = right;

        Node left2 = new Node(4);
        root.left.left = left2;

        Node right2 = new Node(5);
        root.left.right = right2;

        return root;

    }



}
