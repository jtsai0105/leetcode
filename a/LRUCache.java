class LRUCache {
    
    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = head;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            update(key);
            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            addFront(node);
            map.put(key, node);
            evict();
        } else {
            map.get(key).val = value;
            update(key);
        }
    }
    
    private void addFront(Node node) {
        if (head.next == null) {
            head.next = node;
            node.pre = head;
            tail = node;
        } else {
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }
    }
    
    private void update(int key) {
        Node node = map.get(key);
        if (tail == node) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        addFront(node);
    }
    
    private void evict() {
        if (map.size() > capacity) {
            map.remove(tail.key);
            tail.pre.next = null;
            tail = tail.pre;
        }
    }
    
    private void display() {
        Node cur = head.next;
        while (cur != null) {
            System.out.print("(" + String.valueOf(cur.key) + ", " + String.valueOf(cur.val) + ")");
            System.out.print("->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
