class DSU{

    int[] parent;
    int[] rank;
    int components;

    DSU(int n){
        components = n;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int node){
        if(node!= parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    boolean union(int i, int j){

        int p1 = find(i);
        int p2 = find(j);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];  
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        components--;
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            dsu.union(edge[0], edge[1]);
        }

        return dsu.components;
    }
}
