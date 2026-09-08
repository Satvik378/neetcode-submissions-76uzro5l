class Solution {
    public int minCostConnectPoints(int[][] points) {
        //min cost to connect all points together.
        HashMap<Integer, ArrayList<int[]>> adj = new HashMap<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i+1; j<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x2-x1) + Math.abs(y2-y1);

                // adj.putIfAbsent(i, new ArrayList<>());
                // adj.putIfAbsent(j, new ArrayList<>());

                adj.get(i).add(new int[]{dist, j});
                adj.get(j).add(new int[]{dist, i});
            }
        }

        //bfs
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Integer> visited = new HashSet<>();
        
        q.offer(new int[]{0,0});

        int res = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();

            int cost = current[0];
            int node = current[1];

            if(visited.contains(node)) continue;
            visited.add(node);
            res += cost;

            for(int[] nei : adj.get(node)){
                if(!visited.contains(nei[1])){
                    q.offer(nei);
                }
            }
        }

        return visited.size() == n ? res : -1;
    }
}
