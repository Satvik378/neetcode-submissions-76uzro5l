class Solution {
    HashMap<Integer, List<Integer>> hmap;
    Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) return false;

        hmap = new HashMap<>();
        visited = new HashSet<>();

        for(int i = 0; i<n; i++){
            hmap.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){ 
            hmap.get(edge[0]).add(edge[1]);
            hmap.get(edge[1]).add(edge[0]);
            //undirected graph
        }

        if(!dfs(0,-1)) return false;

        return visited.size() == n;
    }

    boolean dfs(int node, int parent){
        if(visited.contains(node)) return false;

        visited.add(node);

        for(int curr : hmap.get(node)){
            if(curr == parent) continue;
            if(!dfs(curr, node)) return false;
        }

        return true;
    }
}
