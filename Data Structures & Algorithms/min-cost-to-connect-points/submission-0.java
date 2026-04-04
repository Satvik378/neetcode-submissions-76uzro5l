class Solution {
    public int minCostConnectPoints(int[][] points) {
        //build adj list.
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0; i<points.length; i++){
            
            adj.putIfAbsent(i, new ArrayList<>());

            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i+1; j<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new int[]{dist, j});
                adj.putIfAbsent(j, new ArrayList<>());
                adj.get(j).add(new int[]{dist, i});
            }
        }
        //same as previous questions.
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        minHeap.offer(new int[]{0,0});
        int cost = 0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int dist = curr[0], node = curr[1];

            if(visited.contains(node)) continue;

            visited.add(node);
            cost = cost + dist;

            for(int[] nei : adj.get(node)){
                if(!visited.contains(nei[1])){
                    minHeap.offer(new int[]{nei[0], nei[1]});
                }
            }
        }

        return visited.size() == points.length ? cost : -1;

    }
}
