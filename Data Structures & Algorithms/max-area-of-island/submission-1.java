class Solution {

    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for(int i= 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid){
        if(row < 0 || col <0 || row>= grid.length || col >= grid[0].length ||
        grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0; //visited
        int res = 1; //count current cell

        for(int[] direction : directions){
            res += dfs(direction[0] + row, direction[1] + col, grid);
        }

        return res;
    }
}
