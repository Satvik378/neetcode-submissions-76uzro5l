class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, visited, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid){

        if(row <0 || col <0 || row >=grid.length || col>=grid[0].length||
        grid[row][col] == '0' || visited[row][col]) return;

        visited[row][col] = true;
        dfs(row+1, col, visited, grid);
        dfs(row-1, col, visited, grid);
        dfs(row, col+1, visited, grid);
        dfs(row, col-1, visited, grid);
    }
}
