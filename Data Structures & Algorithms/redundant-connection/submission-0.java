class DSU{
    int[] parent;
    int[] rank;

    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int node){
        
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public boolean union(int edge1, int edge2){
        int p1 = find(edge1);
        int p2 = find(edge2);

        if(p1 == p2){
            return false;
        }

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        DSU dsu = new DSU(n+1);
        
        int[] res = new int[2];
        
        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }

        return res;
    }
}
