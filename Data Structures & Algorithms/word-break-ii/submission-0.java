class Solution {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordDictSet = new HashSet<>(wordDict);
        dfs(s, 0, wordDictSet, new ArrayList<>());
        return res;
    }


    private void dfs(String s, int index, Set<String> wordDictSet, List<String> words){

        if(index == s.length()){
            //traversed the whole string.
            res.add(String.join(" ", words));
            return;
        }

        for(int i = index; i< s.length(); i++){
            String str = s.substring(index, i+1);

            if(wordDictSet.contains(str)){
                words.add(str);
                dfs(s, i+1, wordDictSet, words);
                words.remove(words.size()-1);
            }
        }
    }
}