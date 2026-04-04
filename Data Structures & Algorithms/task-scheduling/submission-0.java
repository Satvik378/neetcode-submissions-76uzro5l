class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] countArr = new int[26];

        for(char c : tasks){
            countArr[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a); 
        //tasks that are to be scheduled. 
        //count
        //max frequency element comes first.
        for(int i : countArr){
            if(i > 0) maxHeap.offer(i);
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;


        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()){
            time++;

            //optimization now when maxHeap is empty -> no tasks to process.
            //queue is not empty at that point we can jump time.
            if(maxHeap.isEmpty()){
                time = cooldownQueue.peek()[1];
            }
            else{
                int cnt = maxHeap.poll()-1; //task is picked up for processing.

                if(cnt > 0){
                    cooldownQueue.offer(new int[]{cnt, time + n });
                }
            } 

            //one time is reached reinsert the task in queue
            if(!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time){
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
    }
}
