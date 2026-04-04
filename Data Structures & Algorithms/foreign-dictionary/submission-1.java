class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visited;
    List<Character> res;

    public String foreignDictionary(String[] words) {
        
        adj = new HashMap<>();

        for(String word : words){
            for(char c: word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0; i<words.length-1; i++){
            String w1 = words[i], w2 = words[i+1];

            int minLen = Math.min(w1.length(), w2.length());
            
            //edge case
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(
                w2.substring(0, minLen))){
                    return "";
            }

            for(int j = 0; j<minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        res = new ArrayList<>();

        for(char c : adj.keySet()){
            // check cycle using dfs
            if(dfs(c)){
                return "";
            }
        }

        Collections.reverse(res);

        StringBuilder builder = new StringBuilder();

        for(int i= 0; i<res.size(); i++){
            builder.append(res.get(i));
        }

        return builder.toString();
    }

    boolean dfs(char c){

        if(visited.containsKey(c)) return visited.get(c);

        visited.put(c, true);

        for(char nei : adj.get(c)){
            if(dfs(nei)){
                return true;
            }
        }

        visited.put(c, false);
        res.add(c);

        return false;
    }
}
