class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>();

        return dfs(0, set, memo, s);
    }

    private List<String> dfs(int index, Set<String> set, 
    HashMap<Integer, List<String>> memo, String s){

        if(memo.get(index)!=null){
            return memo.get(index);
        }

        List<String> res = new ArrayList<>();

        if(index == s.length()){
            res.add("");
            return res;
        }

        for(int i = index; i<s.length(); i++){
            String word = s.substring(index, i+1);

            if(set.contains(word)){
                List<String> subList = dfs(i+1, set, memo, s);

                for(String temp : subList){
                    if(temp.isEmpty()){
                        res.add(word);
                    }
                    else{
                        res.add(word + " " + temp);
                    }
                }
            }
        }

        memo.put(index, res);
        return res;
    }
}