class Solution {

    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int res = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){

                if(grid[i][j] == 1){
                    res += dfs(i, j, visited, grid);
                }
            }
        }

        return res;
    }

    int dfs(int row, int col, boolean[][] visited, int[][] grid){
        if(row < 0 || col <0 || row >= grid.length || col >= grid[0].length||
        grid[row][col] == 0){
            return 1;
        }
        if(visited[row][col]) return 0;
        visited[row][col] = true;
        int res = 0;

        for(int[] direction: directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            res += dfs(newRow, newCol, visited, grid);
        }

        return res;
    }
}