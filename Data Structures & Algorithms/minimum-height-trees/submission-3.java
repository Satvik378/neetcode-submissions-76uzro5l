class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //mht's are atmost 2.

        if (n == 1) {
            return List.of(0);
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] edgeCount = new int[n];
        Queue<Integer> leaves = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            edgeCount[i] = adj.get(i).size();
            if(edgeCount[i] == 1){
                leaves.offer(i);
            }
        }

        //bfs
        while(!leaves.isEmpty()){
            if(n <=2) return new ArrayList<>(leaves);

            int size = leaves.size(); 
            for(int i = 0; i<size; i++){
                int current = leaves.poll();
                n--;

                for(int nei : adj.get(current)){
                    edgeCount[nei]--;

                    if(edgeCount[nei] == 1){
                        leaves.offer(nei);
                    }
                }
            }

        }

        return new ArrayList<>();
    }
}