class LRUCache {

    class Node{
        int key,value;
        Node prev,next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private Map<Integer,Node> cache;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node node=cache.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.value=value;
            moveToFront(node);
        }else{
            if(cache.size()==capacity){
                removeLRU();
            }

            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToFront(newNode);
        }
    }
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void removeLRU() {
        Node lru = tail.prev;
        remove(lru);
        cache.remove(lru.key);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */