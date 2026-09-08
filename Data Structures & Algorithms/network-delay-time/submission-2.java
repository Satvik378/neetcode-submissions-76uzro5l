class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 1; i<=n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        boolean[] visited = new boolean[n+1];

        q.offer(new int[]{0, k});

        int time = 0;
        int count = 0;

        while(!q.isEmpty()){

            int[] current = q.poll();

            int dist = current[0];
            int node = current[1];

            if(visited[node]) continue;
            visited[node] = true;

            time = dist;
            count++; //counting nodes
            for(int[] nei : adj.get(node)){
                if(!visited[nei[0]]){
                    q.offer(new int[]{dist + nei[1], nei[0]});
                }
            }
        }

        return count == n ? time : -1;

    }
}
