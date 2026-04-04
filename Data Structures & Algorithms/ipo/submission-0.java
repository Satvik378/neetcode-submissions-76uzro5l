class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a,b)-> b-a); 
        //this is for maximizing capital after we complete a project.

        for(int i  = 0 ; i<capital.length; i++){
            capitalQueue.offer(new int[]{capital[i], profits[i]});
        }

        //as we can pick only k distinct projects
        for(int i = 0; i <k; i++){

            while(!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= w){
                profitQueue.offer(capitalQueue.poll()[1]);
            }

            if(profitQueue.isEmpty()) break;

            w = w + profitQueue.poll();
        }

        return w;
    }
}