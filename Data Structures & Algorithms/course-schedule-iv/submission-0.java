class Solution {
    HashMap<Integer, Set<Integer>> map; // this tells us the 
    List<Integer>[] adj;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];
        map = new HashMap<>();

        for(int i = 0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] preq : prerequisites){
            adj[preq[0]].add(preq[1]);
        }

        for(int i = 0; i<numCourses; i++){
            dfs(i);
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] query : queries){
            if(map.get(query[0]).contains(query[1])) res.add(true);
            else res.add(false);
        }

        return res;
    }

    private Set<Integer> dfs(int node){
        if(map.containsKey(node)) return map.get(node);

        Set<Integer> res = new HashSet<>();

        for(int i : adj[node]){
            res.addAll(dfs(i));
        }

        res.add(node);
        map.put(node, res);
        return res;
    }
}