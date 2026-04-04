class Solution {
    public int[] getOrder(int[][] tasks) {
        //enqueTime, processingTime.
        int n = tasks.length;
        //as we will be sorting based on enque time therefore store the original index.
        for(int i = 0; i<n; i++){
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(tasks, (a,b) -> a[0]-b[0]);


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
        a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        //sorted based on processing time and index.

        
        int[] res = new int[n];
        int index = 0; //for result
        int i = 0; //traverse array
        long time = tasks[0][0];

        while(!minHeap.isEmpty() || i<n){

            while(i < n && time >= tasks[i][0]){
                minHeap.offer(new int[]{tasks[i][1], tasks[i][2]}); //processingTime, index
                i++;
            }

            if(minHeap.isEmpty()){
                time = tasks[i][0];
            }
            else{
                int[] temp = minHeap.poll();
                time = time + temp[0];
                res[index++] = temp[1];
            }
        }
        return res;
    }   
}