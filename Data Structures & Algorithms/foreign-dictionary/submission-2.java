class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Integer> state;
    List<Character> res;
    public String foreignDictionary(String[] words) {

        adj = new HashMap<>();
      
      for(String word : words){
        for(char c : word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
        }
      }

      for(int i = 0; i<words.length-1; i++){
        String word1 = words[i];
        String word2 = words[i+1];

        int minLen = Math.min(word1.length() , word2.length());

        if(word1.length() > word2.length() &&          word1.substring(0,minLen).equals(word2.substring(0,minLen)))
        {
            return "";
        }

        for(int j = 0; j<minLen; j++){
            if(word1.charAt(j) != word2.charAt(j)){
                //found first differing character
                adj.get(word1.charAt(j)).add(word2.charAt(j));
                break;
            }
        }
      }

        state = new HashMap<>();
        res = new ArrayList<>();

        for(char c : adj.keySet()){
            if(!dfs(c)){
                return "";
            }
        }

        Collections.reverse(res);

        StringBuilder bu = new StringBuilder();

        for(int i = 0; i<res.size(); i++){
            bu.append(res.get(i));
        }

        return bu.toString();
    }

    private boolean dfs(char c){
        int currentState = state.getOrDefault(c, 0);

        if(currentState == 1){
            return false; //cycle
        }

        if(currentState == 2){
            return true; //already processed
        }

        state.put(c, 1);

        for(char nei : adj.get(c)){
            if(!dfs(nei)) return false;
        }

        state.put(c, 2);
        res.add(c);

        return true;
    }
}
