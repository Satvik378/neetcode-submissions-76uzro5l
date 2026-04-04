class Solution {
    List<Integer>[] adj;
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) return false;
        adj = new ArrayList[n];

        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            //undirected graph therefore adding both.
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // a graph is a valid tree if visits every node and it contains no cycle.
        if(!dfs(0, -1)) return false;

        return visited.size() == n;
    }

    boolean dfs(int node, int parent){

        if(visited.contains(node)) return false;

        visited.add(node);

        for(int crs : adj[node]){
            if(crs == parent) continue;
            if(!dfs(crs, node)) return false;
        }
        return true;
    }
}
