class Solution {
    Map<Integer, List<Integer>> adj;
    int[] state;
    List<Integer> output;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        state = new int[numCourses];
        output = new ArrayList<>();   

        for(int i = 0; i<numCourses; i++){
            adj.put(i, new ArrayList<>()); 
        }

        for(int[] preq : prerequisites){
            adj.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i<numCourses; i++){
            if(!dfs(i)) return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            res[i] = output.get(i);
        }

        return res; 
    }

    boolean dfs(int crs){
        if(state[crs] == 2) return false;
        if(state[crs] == 1) return true;

        state[crs] = 2;

        for(int i : adj.get(crs)){
            if(!dfs(i)) return false;
        }

        state[crs] = 1;
        output.add(crs);
        return true;
    }
}
