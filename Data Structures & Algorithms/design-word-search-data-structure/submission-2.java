class Trie{
    Trie[] children = new Trie[26];
    boolean endOfWord = false;
}

class WordDictionary {
    
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new Trie();
            }
            current = current.children[c-'a'];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }


    private boolean dfs(int index, Trie root, String word){
        Trie current = root;
        for(int i = index; i<word.length(); i++){

            char c = word.charAt(i);

            if(c == '.'){
                //we have to check all children at current level.
                for(Trie child : current.children){
                    if (child!=null && dfs(i+1, child, word)) return true;
                }
                return false;
            }
            else{
                if(current.children[c-'a'] == null){
                    return false;
                }
                current = current.children[c-'a'];
            }
        }

        return current.endOfWord;  
    }
}
