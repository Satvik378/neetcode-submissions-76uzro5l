class Solution {
    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

       for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    return dfs(i, j, grid, visited);
                }
            }
       }
       return 0; 
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited){
        //boundary conditions
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] == 0){
            return 1;
        }

        if(visited[row][col]) return 0;

        visited[row][col] = true;
        
        return (dfs(row + 1, col, grid, visited) +
        dfs(row, col+1, grid, visited) + 
        dfs(row-1, col, grid, visited) + 
        dfs(row, col-1, grid, visited));
    }
}