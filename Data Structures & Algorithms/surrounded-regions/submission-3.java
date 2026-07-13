class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        //boundary conditions.

        //left-right
        for(int i=0; i<rows; i++){
            dfs(i, 0,board); //left
            dfs(i, cols-1,board); //right
        }

        //top-bottom
        for(int j = 0; j<cols; j++){
            dfs(0, j,board); //top
            dfs(rows-1, j,board); //bottom
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || 
        board[row][col] != 'O'){
            return;
        }

        board[row][col] = 'T';

        for(int[] direction : directions){
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            dfs(newRow, newCol, board);
        }
    }
}
