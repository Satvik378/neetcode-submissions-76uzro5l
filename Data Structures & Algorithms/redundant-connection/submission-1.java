class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int node){
        if(node!= parent[node]){
            parent[node] =  find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

        if(p1 == p2) return false; //determine cycle as well.

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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n+1);

        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[0];
    }
}
