import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        int p1 = obj.get(1);
        obj.put(3,3);
        int p2 = obj.get(2);
        obj.put(4,4);
        int p3 = obj.get(1);
        int p4 = obj.get(3);
        int p5 = obj.get(4);
    }
    /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     */
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<Integer, Node>();
    private int size;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        movToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if (size > capacity){
                Node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            movToHead(node);
        }
    }

    private void movToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */