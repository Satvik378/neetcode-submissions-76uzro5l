class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = toposort(k, rowConditions);
        if (rows == null)
            return new int[0][0]; // cycle

        int[] cols = toposort(k, colConditions);
        if (cols == null)
            return new int[0][0]; //cycle
        
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();

        for(int i = 0; i<k; i++){
            rowMap.put(rows[i], i);
            colMap.put(cols[i], i);
        }

        int[][] res = new int[k][k];

        for(int i = 1; i<=k; i++){
            int row = rowMap.get(i);
            int col = colMap.get(i);

            res[row][col] = i; 
        }
        
        return res;

    }
    HashMap<Integer, List<Integer>> adj;
    HashMap<Integer, Integer> stateMap;
    List<Integer> res;
    private int[] toposort(int k, int[][] edges) {
        // build adj list
        adj = new HashMap<>();

        for (int i = 1; i <= k; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        stateMap = new HashMap<>();
        res = new ArrayList<>();

        for (int i = 1; i <= k; i++) {
            if (!dfs(i)) {
                return null;
            }
        }

        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int node) {
        int nodeState = stateMap.getOrDefault(node, 0);

        if (nodeState == 1) {
            return false; // cycle detected
        }

        if (nodeState == 2) {
            return true; // already processed
        }

        stateMap.put(node, 1);

        for (int nei : adj.get(node)) {
            if (!dfs(nei))
                return false;
        }

        stateMap.put(node, 2);
        res.add(node);
        return true;
    }
}