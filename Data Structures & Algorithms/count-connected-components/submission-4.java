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

    //find parent
   public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

        if(p1 == p2){
            return false;
        }

        if(rank[p1] > rank[p2]){
            parent[p2] = parent[p1];
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = parent[p2];
            rank[p2] += rank[p1];
        }

        return true;
    }
}

class Solution {
    
    public int countComponents(int n, int[][] edges) {
        
        DSU dsu = new DSU(n);

        int res = n;

        for(int[] edge : edges){
            if(dsu.union(edge[0], edge[1])){
                //connnected nodes
                res--;
            }
        }

        return res;
    }

    
}
