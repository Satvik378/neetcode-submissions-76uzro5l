class ListNode{

    int value;
    ListNode next;
    ListNode previous;

    ListNode(int value, ListNode next, ListNode prev){
        this.value = value;
        this.next = next;
        this.previous = prev;
    }
}


class DoubleLinkedList{

    //dummy nodes
    ListNode left;
    ListNode right;

    Map<Integer, ListNode> map;

    DoubleLinkedList(){
        this.left = new ListNode(-1, null , null);
        this.right = new ListNode(-1, null , null);

        this.left.next = right;
        this.right.previous = left;

        this.map = new HashMap<>();
    }

    public int length(){
        return map.size();
    }

    public void pushRight(int value){

        ListNode node = new ListNode(value, null , null);

        node.previous = this.right.previous;
        node.next = this.right;

        this.right.previous.next = node;
        this.right.previous = node;

        map.put(value, node);
    }

    public void pop(int value){
        if(map.get(value)!=null){

            ListNode node = map.get(value);

            ListNode prevNode = node.previous;
            ListNode nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.previous = prevNode;

            map.remove(value);
        }
    }


    public int popLeft(){
        // pop LRU
        int res = this.left.next.value;
        pop(res);

        return res;
    }

    public void update(int value){
        pop(value);
        pushRight(value);
    }
}

class LFUCache {
   
    int capacity;
    int lfuCount;
    HashMap<Integer, Integer> valMap;
    HashMap<Integer, Integer> countMap;
    HashMap<Integer, DoubleLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        this.valMap = new HashMap<>(); //key -> value
        this.countMap = new HashMap<>(); //key -> count
        this.listMap = new HashMap<>(); //countFreq -> LinkedList.
    }

    private void counter(int key){
        int count = countMap.get(key);
        countMap.put(key, count+1);

        //as count is incremented for the key we have to remove this from previous count and add to new count.
        listMap.putIfAbsent(count, new DoubleLinkedList());
        listMap.get(count).pop(key);

        listMap.putIfAbsent(count + 1, new DoubleLinkedList());
        listMap.get(count+1).pushRight(key);

        if(count == this.lfuCount && listMap.get(count).length() == 0){
            this.lfuCount++;
        }
    }
    
    public int get(int key) {

        if(valMap.get(key)!=null){
            //we have to increase the count of the fetched key.
            counter(key);
            return valMap.get(key);
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.capacity == 0) return;

        if(valMap.get(key) == null && valMap.size() == capacity){
            //capacity reached
            //evict some value
            int toRemove = listMap.get(lfuCount).popLeft();
            valMap.remove(toRemove);
            countMap.remove(toRemove);
        }

        valMap.put(key, value);
        countMap.putIfAbsent(key, 0);
        //update the count map as well.
        this.counter(key);
        //update the lfuCount.
        this.lfuCount = Math.min(countMap.get(key), lfuCount);
    }
}