class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();


        for(int i=0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{-1, 0}, {1,0}, {0,-1}, {0,1}};
        
        while(!q.isEmpty()){
           
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] direction : directions){
                int r = row + direction[0];
                int c = col + direction[1];

                if(r < 0 || c <0 || r >= rows || c >= cols||
                grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.offer(new int[]{r,c});
                grid[r][c] = grid[row][col] + 1;
            }
            
        }    
    }
}
