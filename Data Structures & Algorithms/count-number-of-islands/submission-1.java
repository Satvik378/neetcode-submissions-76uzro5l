class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        //boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid){

        if(row <0 || col <0 || row >=grid.length || col>=grid[0].length||
        grid[row][col] == '0') return;

       grid[row][col] = '0';
        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);
    }
}
