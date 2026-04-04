class Pair{
    String node;
    double weight;

    Pair(String node, double weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {

    Map<String, List<Pair>> map;
    Set<String> visited;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        map = new HashMap<>();

        for(int i = 0; i<equations.size(); i++){
            map.putIfAbsent(equations.get(i).get(0), new ArrayList<>());
            map.putIfAbsent(equations.get(i).get(1), new ArrayList<>());

            map.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            map.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1/values[i]));
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i<queries.size(); i++){
            visited = new HashSet<>();
            String src = queries.get(i).get(0);
            String targ = queries.get(i).get(1);
            
            res[i] = dfs(src, targ);
        }

        return res;
    }


    double dfs(String src, String targ){

        if(!map.containsKey(src) || !map.containsKey(targ)) return -1.0;

        if(src.equals(targ)) return 1.0;

        visited.add(src);
        
        for(Pair pair : map.get(src)){
            if(!visited.contains(pair.node)){

                double res = dfs(pair.node, targ);

                if(res != -1.0){
                    return pair.weight * res;
                }
            }
        }

        return -1.0;
    }
}