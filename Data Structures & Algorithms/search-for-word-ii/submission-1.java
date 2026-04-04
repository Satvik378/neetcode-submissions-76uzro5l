class Trie{
    Trie[] children = new Trie[26];
    boolean endOfWord = false;
}

class Solution {

    List<String> res;
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        
        Trie root= new Trie();

        for(String word : words){
            addToTrie(word, root);
        }

        int rows = board.length;
        int cols = board[0].length;
        
        visited = new boolean[rows][cols];
        res= new ArrayList<>();
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                dfs(i, j, root, board, "");
            }
        }
        return res;
    }

    private void dfs(int row, int col, Trie current, char[][] board, String word){

        if(row < 0 || col <0 || row>=board.length || col >= board[0].length||
        visited[row][col] || current.children[board[row][col]- 'a'] == null){
            return;
        }

        visited[row][col] = true;

        current = current.children[board[row][col]- 'a'];
        word += board[row][col];

        if(current.endOfWord){
            res.add(word);
            current.endOfWord = false;
        }
        dfs(row+1, col, current, board, word);
        dfs(row-1, col, current, board, word);
        dfs(row, col+1, current, board, word);
        dfs(row, col-1, current, board, word);

        visited[row][col] = false;

    }

    private void addToTrie(String word, Trie root){
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
 