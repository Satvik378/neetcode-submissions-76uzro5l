class Solution {

    List<Integer>[] adj;
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]); //formed adjacency list.
            adj[edge[1]].add(edge[0]);
        }

        //now dfs
        int res = 0;
        for(int k = 0; k<n; k++){
            if(!visited[k]){
                dfs(k);
                res++;
            }
        }

        return res;
    }

    private void dfs(int n){

        visited[n] = true;
        for(int i : adj[n]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
