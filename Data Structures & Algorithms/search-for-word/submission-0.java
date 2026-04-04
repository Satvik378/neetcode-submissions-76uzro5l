class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(dfs(board, word, new boolean[n][m], i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfs(char[][] board, String word, boolean[][] visited, int row, int column,
    int index){

        if(index == word.length()){
            //we have traversed all words.
            //index is for trcking the words.
            return true;
        }

        //out of bound handling
        if(row < 0 || row >= board.length ||
            column < 0 || column >= board[0].length ||
            board[row][column] != word.charAt(index) ||
            visited[row][column]){
                return false;
            }

        //backtracking
        visited[row][column] = true;
        boolean temp = 
        dfs(board, word, visited, row+1, column, index+1)||
        dfs(board, word, visited, row, column+1, index+1)||
        dfs(board, word, visited, row, column-1, index+1)||
        dfs(board, word, visited, row-1, column, index+1);

        visited[row][column] = false;

        return temp;
    }
}
