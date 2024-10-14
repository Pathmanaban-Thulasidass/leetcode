class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node() {
        this.key = -1;
        this.val = -1;
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
            insertNode(temp);
            return temp.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            removeNode(temp);
            temp.val = value;
            insertNode(temp);
        } else {
            Node temp = new Node(key, value);
            if (map.size() == capacity) {
                Node deleteNode = tail.prev;
                removeNode(deleteNode);
                map.remove(deleteNode.key);
            }
            insertNode(temp);
            map.put(key, temp);

        }
    }

    public void insertNode(Node temp) {
        Node rightNode = head.next;
        head.next = temp;
        rightNode.prev = temp;
        temp.prev = head;
        temp.next = rightNode;
    }

    public void removeNode(Node temp) {
        Node left = temp.prev;
        Node right = temp.next;
        temp.next = null;
        temp.prev = null;
        left.next = right;
        right.prev = left;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */
