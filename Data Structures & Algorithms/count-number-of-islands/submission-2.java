class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for(int i = 0; i<rows; i++){
            for(int j=0; j<cols; j++){

                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    void dfs(int row, int col, char[][] grid){
        if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length ||
        grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for(int[] direction : directions){
            dfs(direction[0] + row, direction[1] + col, grid);
        }
    }
}
