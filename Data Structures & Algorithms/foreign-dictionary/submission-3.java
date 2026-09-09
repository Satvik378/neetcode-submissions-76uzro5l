class Solution {
    HashMap<Character, List<Character>> adj;
    HashMap<Character, Integer> state;
    List<Character> res;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        state = new HashMap<>();
        res = new ArrayList<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.put(c, new ArrayList<>());
            }
        }

        for(int i = 0 ; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int minLen = Math.min(word1.length(), word2.length());

            if(word1.substring(0,minLen).equals(word2.substring(0,minLen))
            &&  word1.length() > word2.length()){
                return "";
            }

            for(int j = 0; j<minLen; j++){
                if(word1.charAt(j)!= word2.charAt(j)){
                    //found 1st differing char
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
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

    private boolean dfs(char c){

        if(state.getOrDefault(c, 0) == 1){
            return false;
        }

        if(state.getOrDefault(c,0) == 2){
            return true;
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
