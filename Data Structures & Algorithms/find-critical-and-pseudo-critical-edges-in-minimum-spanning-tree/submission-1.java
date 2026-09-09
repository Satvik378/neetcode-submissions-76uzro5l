class DSU{
    int[] rank;
    int[] parent;
    int components;

    DSU(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        this.components = n;

        for(int i = 0; i <n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    private int find(int node){

        if(node!=parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int a, int b){
        int p1 = find(a);
        int p2 = find(b);

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
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        List<int[]> edgeList = new ArrayList<>();

        for(int i = 0; i<edges.length; i++){
            edgeList.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }

        Collections.sort(edgeList, (a,b) -> a[2]- b[2]);

        int maxWt = 0;
        DSU dsu = new DSU(n);

        for(int[] edge : edgeList){
            if(dsu.union(edge[0], edge[1])){
                maxWt += edge[2];
            }
        }

        List<Integer> criticalEdge = new ArrayList<>();
        List<Integer> pCriticalEdge = new ArrayList<>();

        for(int[] edge : edgeList){

            //criticalEdge
            //skip this edge
            DSU without = new DSU(n);
            int wt = 0;
            for(int[] other : edgeList){
                if(other[3] != edge[3] && without.union(other[0], other[1])){
                    wt += other[2];
                }
            }

            if(wt > maxWt || without.components != 1){
                criticalEdge.add(edge[3]);
                continue;
            }

            DSU with = new DSU(n);
            with.union(edge[0], edge[1]);
            wt = edge[2]; //include this edge

            for(int[] other : edgeList){
                if(with.union(other[0], other[1])){
                    wt += other[2];
                }
            }

            if(wt == maxWt){
                pCriticalEdge.add(edge[3]);
            }
        }

        return Arrays.asList(criticalEdge, pCriticalEdge);
    }
}