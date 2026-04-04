class DoubleLinkedList{
    int value;
    DoubleLinkedList next;
    DoubleLinkedList previous;

    DoubleLinkedList(int value, DoubleLinkedList next, DoubleLinkedList previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}

class MyCircularQueue {

    int capacity;
    DoubleLinkedList left;
    DoubleLinkedList right;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.left = new DoubleLinkedList(0, null, null);
        this.right = new DoubleLinkedList(0, null, this.left);

        this.left.next  = this.right; 
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) return false;

        DoubleLinkedList currentNode = new DoubleLinkedList(value, null, null);

        DoubleLinkedList prevNode = this.right.previous;

        prevNode.next = currentNode;
        this.right.previous = currentNode;

        currentNode.previous = prevNode;
        currentNode.next = this.right;

        this.capacity--;

        return true; 
    }
    
    public boolean deQueue() {
        if(this.isEmpty()) return false;

        DoubleLinkedList temp = this.left.next.next;

        this.left.next = temp;
        temp.previous = this.left;
        this.capacity++;
        return true;

    }
    
    public int Front() {
        if(isEmpty()) return -1;

        return this.left.next.value;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        return this.right.previous.value;
    }
    
    public boolean isEmpty() {
        return (this.left.next == this.right)? true: false;
    }
    
    public boolean isFull() {
        return this.capacity == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */