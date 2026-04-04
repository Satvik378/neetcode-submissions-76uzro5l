class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a); //maxheap

        for(int i : stones){
            queue.offer(i);
        }

        while(queue.size() > 1){
            int temp = queue.poll() - queue.poll();
            if(temp > 0){
                queue.offer(temp);
            }
        }

        return queue.size()> 0 ? queue.poll() : 0;
        
    }
}
