class MedianFinder {

    //2 heap prblm
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> bigHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a); //maxheap
        bigHeap = new PriorityQueue<>(); //minheap
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);

        if(smallHeap.size() - bigHeap.size() > 1 || 
        (!bigHeap.isEmpty() && smallHeap.peek() > bigHeap.peek()))
        {    
            bigHeap.offer(smallHeap.poll());
        }
        
        if(bigHeap.size() - smallHeap.size() > 1){
            smallHeap.offer(bigHeap.poll());
        }
    }
    
    public double findMedian() {

        int n = bigHeap.size();
        int m = smallHeap.size();
        
        if(n == m){
            return (double)((smallHeap.peek() + bigHeap.peek())/2.0);
        }
        else if(n > m){
            return (double)bigHeap.peek();
        }
        else{
            return (double)smallHeap.peek();
        }
    }
}
