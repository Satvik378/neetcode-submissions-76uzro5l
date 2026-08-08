class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        //in order to check the neighbours we have to build adj list.
        for(int[] time : times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        //dijkstras
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean[] visited = new boolean[n+1];

        q.offer(new int[]{0, k}); //dist, k

        int time = 0;
        int countNodes = 0;

        while(!q.isEmpty()){

            int[] current = q.poll();
            int node = current[1];
            int dist = current[0];

            if(visited[node]) continue;
            visited[node] = true;
            countNodes++;
            time = dist;

            for(int[] nei : adj.get(node)){
                int neiNode = nei[0];
                int neiDist = nei[1];

                if(!visited[neiNode]){
                    q.offer(new int[]{dist + neiDist, neiNode});
                }
            }
        }

        return countNodes == n ? time : -1;
    }
}
