class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> visited = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i< numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] j : prerequisites){
            map.get(j[0]).add(j[1]);
        }

        for(int k = 0; k<numCourses; k++){

            if(!dfs(k)) return false;
        }

        return true;
    }

    private boolean dfs(int course){

        if(visited.contains(course)) return false;
        if(map.get(course).isEmpty()) return true;

        visited.add(course);

        for(int dependentCourses : map.get(course)){
            if(!dfs(dependentCourses)) return false;
        }

        visited.remove(visited.size()-1);
        map.put(course, new ArrayList<>());
        return true;
    }
}
