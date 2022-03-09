import java.util.PriorityQueue;

public class KMerge {

    class Node implements Comparable {
        int value;
        Node next;

        Node() {
        }


        Node(int value) {
            this.value = value;

        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }


        @Override
        public int compareTo(Object o) {
            Node n2 = (Node) o;

            return  n2.value - this.value ;
        }
    }

    public Node merge() {
        Node[] cList = new Node[3];

        Node n3 = new Node(1);
        Node n2 = new Node(3,n3);
        Node n1 = new Node(9,n2);


        cList[0] = n1;

        Node n6 = new Node(0);
        Node n5 = new Node(4,n6);
        Node n4 = new Node(6,n5);
        cList[1] = n4;


        Node n8 = new Node(2);
        Node n7 = new Node(11,n8);
        cList[2] = n7;


        Node head = new Node();
        Node dummy = head;


        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < cList.length; i++) {
            pq.add(cList[i]);
        }

        while (true) {
            if (pq.size() <= 0) {
                break;
            }
            Node newNode = pq.poll();
            if (newNode.next != null) {
                pq.add(newNode.next);
            }

            head.next = newNode;
            head = head.next;

        }

        return dummy.next;
    }


    public static void main(String[] args) {
        KMerge kMerge = new KMerge();
        Node res = kMerge.merge();
        while(res!=null){
            System.out.println(res.value);
            res = res.next;
        }




    }
}
