class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();

        for(String word : dictionary){
            set.add(word);
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dfs(0, s, set, cache);
    }

    private int dfs(int index, String s, Set<String> set, HashMap<Integer, Integer> cache){
        if(index == s.length()){
            return 0;
        }

        if(cache.get(index)!=null){
            return cache.get(index);
        }

        int res = 1+ dfs(index+1, s, set, cache); //skip one char

        for(int i = index; i<s.length(); i++){

            if(set.contains(s.substring(index, i+1))){
                res = Math.min(res, dfs(i+1, s, set, cache));
            }
        }
        cache.put(index, res);
        return res;
    }
}