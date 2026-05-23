class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize!=0) return false;
        
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i : hand){
            count.put(i, count.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Integer>  minHeap = new PriorityQueue<>(count.keySet());

        while(!minHeap.isEmpty()){
           int firstIndex = minHeap.peek();

           for(int i = firstIndex; i < firstIndex + groupSize; i++){
                if(count.getOrDefault(i,0) == 0) return false;
                count.put(i, count.get(i)-1);

                if(count.get(i) == 0){
                    // must match heap top
                    if(i != minHeap.peek())
                        return false;

                    minHeap.poll();
                }
           } 
        }

        return true;
    }
}
