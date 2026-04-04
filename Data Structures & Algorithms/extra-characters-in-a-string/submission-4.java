class Trie{
    Trie[] children = new Trie[26];
    boolean endOfWord = false;
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        Trie root = new Trie();
        
        for(String str : dictionary){
            addWordsToTrie(str, root);
        }

        HashMap<Integer, Integer> cache = new HashMap<>();

        return dfs(0, s, cache, root);

    }

    private int dfs(int index, String s, HashMap<Integer, Integer> cache,
    Trie root){

        if(index == s.length()) return 0;
        if(cache.containsKey(index)) return cache.get(index);

        int res = 1 + dfs(index+1, s, cache, root);
        Trie current = root;

        for(int i = index; i<s.length(); i++){
            if(current.children[s.charAt(i)-'a'] == null){
                //no children with this start char.
                break;
            }

            current = current.children[s.charAt(i)-'a'];

            if(current.endOfWord){
                res = Math.min(res, dfs(i+1, s, cache, current));
            }
        }
        cache.put(index, res);
        return res;
    }

    private void addWordsToTrie(String word, Trie root){
        Trie current = root;

        for(char c : word.toCharArray()){
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new Trie();
            }
            current = current.children[c-'a'];
        }
        current.endOfWord = true;
    }
}