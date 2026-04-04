class Solution {

    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[] rowOrder = topoSort(k, rowConditions);
        if(rowOrder == null) return new int[0][0];

        int[] colOrder = topoSort(k, colConditions);
        if(colOrder == null) return new int[0][0];

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for(int i = 0; i<rowOrder.length; i++){
            rowMap.put(rowOrder[i], i);
        }

        for(int i=0; i<colOrder.length; i++){
            colMap.put(colOrder[i], i);
        }


        int[][] res = new int[k][k];

        for(int i = 1; i<=k; i++){
            int row = rowMap.get(i);
            int col = colMap.get(i);

            res[row][col] = i; 
        }

        return res;
    }

    Set<Integer> visited;
    Set<Integer> path; //detecting the cycle.
    List<Integer> order;
    
    public int[] topoSort(int k, int[][] edges){

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i<=k; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        visited = new HashSet<>();
        path = new HashSet<>();
        order = new ArrayList<>();

        for(int i = 1; i<=k; i++){
            if(!visited.contains(i)){
                if(!dfs(i, adj)){
                    return null;
                }
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj){

        if(path.contains(src)) return false;
        if(visited.contains(src)) return true;

        path.add(src);
        visited.add(src);

        for(int nei : adj.get(src)){
            if(!dfs(nei, adj)) return false;
        }

        path.remove(src);
        order.add(src);
        return true;
    }
}