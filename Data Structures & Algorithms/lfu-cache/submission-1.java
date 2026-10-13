class ListNode{
    int value;
    ListNode next;
    ListNode prev;

    ListNode(int value, ListNode next, ListNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class DoubleLinkedList{
    ListNode left;
    ListNode right;

    HashMap<Integer, ListNode> map;

    DoubleLinkedList(){
        this.left = new ListNode(-1, null, null);
        this.right = new ListNode(-1, null, null);

        this.left.next = this.right;
        this.right.prev = this.left;

        map = new HashMap<>();
        //this map holds the value to the ListNode.
    }

    public int length(){
        return map.size();
    }

    public void pushRight(int value){
        ListNode node = new ListNode(value, null, null);

        ListNode previous = this.right.prev;

        previous.next = node;
        this.right.prev = node;

        node.next = this.right;
        node.prev = previous;

        this.map.put(value, node);
    }

    public void pop(int value){
        if(map.containsKey(value)){

            ListNode curr = map.get(value);

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            map.remove(value);
        }
    }

    public int popLeft(){
        //LRU pop
        int res = this.left.next.value;
        pop(res);
        return res;
    }
}

class LFUCache {

    int capacity;
    int lfuCount;
    HashMap<Integer, Integer> countMap;
    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, DoubleLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        countMap = new HashMap<>();
        valueMap = new HashMap<>();
        listMap = new HashMap<>();
    }

    public void counter(int key){
        int count = countMap.get(key);
        countMap.put(key, count+1);

        listMap.putIfAbsent(count, new DoubleLinkedList());
        listMap.get(count).pop(key);

        listMap.putIfAbsent(count+1, new DoubleLinkedList());
        listMap.get(count+1).pushRight(key);

        if(count == this.lfuCount && listMap.get(count).length() == 0){
            //this count is zero now.
            //and as its get so the key has moved onto next count DLL.
            this.lfuCount++;
        }
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)){
            //increase count of this key
            counter(key);
            return valueMap.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.capacity == 0) return;

        if(!valueMap.containsKey(key) && this.capacity == valueMap.size()){

            int toRemove = listMap.get(lfuCount).popLeft();
            countMap.remove(toRemove);
            valueMap.remove(toRemove);
        }
        
        //now put
        valueMap.put(key, value);
        countMap.putIfAbsent(key, 0); //we could be also upadting the key.

        this.counter(key);
        this.lfuCount = Math.min(lfuCount, countMap.get(key));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */