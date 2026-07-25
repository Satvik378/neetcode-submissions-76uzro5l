class Solution {
    Map<Integer, List<Integer>> adj;
    Map<Integer, Set<Integer>> map;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        adj = new HashMap<>();
        map = new HashMap<>(); //set of reachable nodes from this node.

        for(int i = 0; i<numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] preq : prerequisites){
            adj.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i<numCourses; i++){
            dfs(i);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            if(map.get(query[0]).contains(query[1])){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }

        return res;
    }

    Set<Integer> dfs(int node){
        if(map.containsKey(node)) return map.get(node);

        Set<Integer> res = new HashSet<>();

        for(int nei : adj.get(node)){
            res.addAll(dfs(nei));
        }
        res.add(node);
        map.put(node, res);
        return res;
    }
}