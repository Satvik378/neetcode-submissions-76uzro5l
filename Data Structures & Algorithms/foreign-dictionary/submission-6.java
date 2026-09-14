class Solution {
    HashMap<Character, List<Character>> adj;
    HashMap<Character, Integer> stateMap;
    List<Character> res;

    public String foreignDictionary(String[] words) {
      //adj list based on sort order
       adj = new HashMap<>();
      //toposort so carry state map
       stateMap = new HashMap<>();
       res = new ArrayList<>();

      for(String word : words){
        for(char c : word.toCharArray()){
            adj.putIfAbsent(c, new ArrayList<>());
        }
      }

      for(int i = 0; i<words.length-1; i++){
        String word1 = words[i];
        String word2 = words[i+1];

        int minLen = Math.min(word1.length(), word2.length());

        if(word1.substring(0, minLen).equals(word2.substring(0,minLen)) 
            && word1.length() > word2.length()){
                return "";
        }

        for(int j= 0; j<minLen; j++){
            char a = word1.charAt(j);
            char b = word2.charAt(j);
            if(a != b){
                //found 1st differing character.
                adj.get(a).add(b);
                break;
            }
        }
      }

      for(char c : adj.keySet()){
        if(!dfs(c)){
            return "";
        }
      }

      Collections.reverse(res);
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i<res.size(); i++){
        builder.append(res.get(i));
      }

      return builder.toString();
    }

    private boolean dfs(Character c){
        int state = stateMap.getOrDefault(c, 0);
        if(state == 1) return false;
        if(state == 2) return true;

        stateMap.put(c, 1);

        for(char nei : adj.get(c)){
            if(!dfs(nei)) return false;
        }

        stateMap.put(c, 2);
        res.add(c);
        return true;
    }
}
