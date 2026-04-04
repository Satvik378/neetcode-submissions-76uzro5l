class UnionFind{
    int[] parent, rank;
    int maxCount;
    
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        maxCount = 1;
        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p){
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
            maxCount = rank[p1];
        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
            maxCount = rank[p2];
        }
        return true;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, Integer> factorIndex = new HashMap<>();

        for(int i = 0; i<n; i++){
            int f = 2;
            int num = nums[i];

            while(f*f <= num){
                if(num%f == 0){
                    //factor
                    if(factorIndex.containsKey(f)){
                        uf.union(factorIndex.get(f), i);
                    }
                    else{
                        factorIndex.put(f, i);
                    }

                    while(num % f == 0){
                        num = num / f;
                    }
                }
                f++;
            }

            if(num > 1){
                if(factorIndex.containsKey(num)){
                    uf.union(factorIndex.get(num), i);
                }
                else{
                    factorIndex.put(num, i);
                }
            }
        }

        return uf.maxCount == n;

    }
}