public class Kchain {


    public static void main(String[] args) {
        Kchain kchain = new Kchain();
        int[] intList = new int[]{1,2,3,4,5};
        Node root = new Node(0);
        Node current = root;
        int length = intList.length;
        for(int num : intList){
            current.next = new Node();
            current = current.next;
            current.val = num;
        }
        kchain.reverseKGroup(root.next,3,length);

    }

    static class Node{
        public int val;
        public Node next;
        Node(){
            this.val = 0;
            this.next = null;
        }

        Node(int val){
            this.val = val;
            this.next = null;

        }
        Node(int val,Node next){
            this.val = val;
            this.next = next;

        }
    }



    public Node reverseKGroup(Node root,int k,int length){
        int count = 0;
        int index = 0;


        Node totalPre = new Node();
        totalPre.next = root;

        Node pre = new Node();
        pre.next = root;
        Node source = null;
        Node current = root;
        Node nextNode = root.next;
        while(length-index>k){

            for(int i=0;i<k-1;i++){
                current.next = nextNode.next;
                nextNode.next = current;
                pre.next= nextNode;

                nextNode = current.next.next;
                current=current.next;
                pre = current;
                index++;
            }
            pre = current;
            current = pre.next;



        }
        return source.next;
    }
}
