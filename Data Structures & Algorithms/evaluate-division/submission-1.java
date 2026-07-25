class Pair{
    String node;
    double dist;

    Pair(String node, double dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    Map<String, List<Pair>> adj;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();

        for(int i = 0; i<equations.size(); i++){
            String src = equations.get(i).get(0);
            String tar = equations.get(i).get(1);

            adj.putIfAbsent(src, new ArrayList<>());
            adj.putIfAbsent(tar, new ArrayList<>());
            
            adj.get(src).add(new Pair(tar, values[i]));
            adj.get(tar).add(new Pair(src, 1.0/values[i]));
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String tar = queries.get(i).get(1);

            res[i] = bfs(src, tar);
        }
        return res;
    }

    double bfs(String src, String tar){

        if(!adj.containsKey(src) || !adj.containsKey(tar)) return -1.0;

        Queue<Pair> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(new Pair(src, 1.0));
        visited.add(src);

        while(!q.isEmpty()){
            Pair current = q.poll();
            String currentNode = current.node;
            double currentDist = current.dist;

            if(currentNode.equals(tar)) return currentDist;

            for(Pair nei : adj.get(currentNode)){
                String temp = nei.node;
                double tempDist = nei.dist;

                if(!visited.contains(temp)){
                    q.offer(new Pair(temp, currentDist * tempDist));
                    visited.add(temp);
                }
            }
        }
        return -1.0;
    }
}