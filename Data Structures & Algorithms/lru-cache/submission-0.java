class DoubleLinkedList{
    int value;
    int key;
    DoubleLinkedList next;
    DoubleLinkedList previous;

    DoubleLinkedList(int key, int value, DoubleLinkedList next, DoubleLinkedList previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
        this.key = key;
    }
}

class LRUCache {

    HashMap<Integer, DoubleLinkedList> cache;
    int capacity;
    DoubleLinkedList left;
    DoubleLinkedList right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.left = new DoubleLinkedList(0,0, null, null);
        this.right = new DoubleLinkedList(0,0, null , this.left);

        this.left.next = this.right;

    }

    private void removeNode(DoubleLinkedList node){

        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void pushRight(DoubleLinkedList node){

        DoubleLinkedList prevNode = this.right.previous;
        this.right.previous = node;
        node.next = this.right;

        prevNode.next = node;
        node.previous = prevNode;
    }
    
    public int get(int key) {
        if(cache.get(key)!=null){
            //node became the MRU now.
           DoubleLinkedList node =  cache.get(key);

            this.removeNode(node);
            this.pushRight(node);

            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {

        if(cache.get(key)!=null){
            //capacity will remain same.
            //update the value at the node.
            //node will become MRU.
            DoubleLinkedList node =  cache.get(key);
            node.value = value;

            this.removeNode(node);
            this.pushRight(node);
        }
        else{
            //new key check capacity.
            DoubleLinkedList node = new DoubleLinkedList(key,value, null, null);
            this.pushRight(node);
            cache.put(key, node);

            if(cache.size() > this.capacity){
                cache.remove(this.left.next.key); // i don't have key in DLL
                this.removeNode(this.left.next);
            }
        }
        
    }
}
