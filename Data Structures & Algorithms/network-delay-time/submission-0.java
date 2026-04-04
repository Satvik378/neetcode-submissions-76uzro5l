class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] time : times){
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new int[]{time[1], time[2]}); //node, dist
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = 
                        new PriorityQueue<>((a,b)-> a[0]-b[0]);
        
        minHeap.offer(new int[]{0, k}); //dist, node

        int time = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            int dist = curr[0], node = curr[1];

            if(visited.contains(node)) continue;

            visited.add(node);
            time = dist;
            //visit neighbours
            
            if(adj.containsKey(node)){
                for(int[] nei : adj.get(node)){
                    if(!visited.contains(nei[0])){
                        minHeap.offer(new int[]{dist + nei[1], nei[0]});
                    }
                }
            }
            
        }

        return visited.size() == n ? time : -1;


    }
}
