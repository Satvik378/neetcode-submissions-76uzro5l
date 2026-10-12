class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> hmap;
    ListNode left;
    ListNode right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap = new HashMap<>();

        left = new ListNode(-1, -1);
        right = new ListNode(-1, -1);

        left.next = right;
        right.prev = left;
    }

    private void removeNode(ListNode node){
        
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(ListNode node){
        //add node at MRU i.e. right side.
        ListNode prevNode = this.right.prev;

        prevNode.next = node;
        node.next = this.right;
        node.prev = prevNode;
        this.right.prev = node;
    }
    
    public int get(int key) {
        
        if(hmap.containsKey(key)){
            ListNode node = hmap.get(key);
            
            //now as this is MRU
            removeNode(node);
            addNode(node);

            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(hmap.containsKey(key)){
            removeNode(hmap.get(key));
        }

        ListNode node = new ListNode(key, value);
        addNode(node);
        hmap.put(key, node);

        if(hmap.size() > capacity){
            //remove LRU
            ListNode curr = this.left.next;
            hmap.remove(curr.key);
            removeNode(curr);
        }

    }
}
