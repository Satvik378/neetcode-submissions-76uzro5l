class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        //sort based on startpt.

        Arrays.sort(trips, (a,b) -> a[1]-b[1]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        //endPt, no.of passengers
        
        int currPass = 0;
        
        for(int[] trip : trips){
            
            int numPass = trip[0];
            int start = trip[1];
            int end = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= start){
                currPass -= minHeap.poll()[1];
            }

            currPass += numPass;

            if(currPass > capacity) return false;

            minHeap.offer(new int[]{end, numPass});
        }

        return true;
    }
}