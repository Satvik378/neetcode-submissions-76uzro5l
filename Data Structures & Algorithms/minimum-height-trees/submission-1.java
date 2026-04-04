class Solution {

    List<Integer>[] adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return Arrays.asList(0);
        
        adj = new ArrayList[n];

        for(int i = 0; i <n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] edge_cnt = new int[n];
        Queue<Integer> leaves = new LinkedList<>();

        for(int i = 0; i<n; i++){
            edge_cnt[i] = adj[i].size();

            if(edge_cnt[i] == 1){
                //find leave nodes
                leaves.offer(i);
            } 
        }

        while(n > 2){
            int size = leaves.size();

            for(int i = 0; i<size; i++){
                int leave = leaves.poll();
                n--;

                for(int neighbour : adj[leave]){
                    edge_cnt[neighbour]--;

                    if(edge_cnt[neighbour] == 1){
                        leaves.offer(neighbour);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}