class UnionFind{
    int[] parent, rank;
    int maxRank;
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        maxRank = 1;
        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p){
        if(p!=parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public boolean union(int e1, int e2){
        int p1 = find(e1), p2 = find(e2);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
            maxRank = rank[p1];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
            maxRank = rank[p2];
        }
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList<>();

        for(int i = 0; i<edges.length; i++){
            edgeList.add(new int[]{edges[i][0], edges[i][1], edges[i][2], i});
        }
        
        Collections.sort(edgeList, (a,b) -> a[2]-b[2]); //sort by min wt.

        UnionFind uf = new UnionFind(n);
        int mstWt = 0; //we used kruskal's to find the wt of the spaning tree.
        for(int[] edge : edgeList){
            if(uf.union(edge[0], edge[1])){
                mstWt += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pCritical = new ArrayList<>();

        for(int[] edge : edgeList){
            UnionFind withOut = new UnionFind(n);
            int wt = 0;

            for(int[] other : edgeList){
                if(other[3] != edge[3] && withOut.union(other[0], other[1])){
                    wt += other[2];
                }
            }

            if(withOut.maxRank != n || wt > mstWt){
                critical.add(edge[3]);
                continue;
            }

            //pusedoCritical
            UnionFind with = new UnionFind(n);
            with.union(edge[0], edge[1]);
            wt = edge[2];

            for(int[] other : edgeList){
                if(with.union(other[0], other[1])){
                    wt += other[2];
                }
            }

            if(wt == mstWt){
                pCritical.add(edge[3]);
            }
        }

        return Arrays.asList(critical, pCritical);

    }
}