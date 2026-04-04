class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void solve(char[][] board) {
        
        //basically i will change the border O with some other char.

        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        
        //traverse border row
        for(int r = 0; r<rows; r++){
            dfs(r, 0, visited, board);
            dfs(r, cols-1, visited, board);
        }

        for(int c = 0; c< cols; c++){
            dfs(0, c, visited, board);
            dfs(rows-1, c, visited, board);
        }


        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] board){
        if(row < 0 || col <0 || row >= board.length || col >= board[0].length ||
        board[row][col] == 'X' || visited[row][col]){
            return;
        }

        if(board[row][col] == 'O'){
            board[row][col] = 'T';
        }

        visited[row][col] = true;

        for(int[] direc : directions){
            int nr = row + direc[0];
            int nc = col + direc[1];
            dfs(nr, nc, visited, board);
        }
    }
}
