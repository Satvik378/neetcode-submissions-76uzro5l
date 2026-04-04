class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid){
        //water bound cases
        if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(row+1, col, grid) + dfs(row-1, col, grid) + dfs(row, col+1, grid) +
        dfs(col, row-1, grid);
    }
}
