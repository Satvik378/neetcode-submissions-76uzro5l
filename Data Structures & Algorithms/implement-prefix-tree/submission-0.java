class Trie{
    Trie[] children = new Trie[26];
    boolean endOfWord = false;
}
class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie(); 
    }

    public void insert(String word) {
        Trie current = root;
        for(char c : word.toCharArray()){
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new Trie();
            }
            current = current.children[c-'a'];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        Trie current = root;
        for(char c : word.toCharArray()){
            if(current.children[c-'a'] == null){
                return false;
            }
            current = current.children[c-'a'];
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = root;
        for(char c : prefix.toCharArray()){
            if(current.children[c-'a'] == null){
                return false;
            }
            current = current.children[c-'a'];
        }
        return true;
    }
}
