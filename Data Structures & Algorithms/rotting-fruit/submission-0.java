class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int rows = grid.length; 
        int cols = grid[0].length;

        int freshCount = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }

                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int time = 0;
        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty() && freshCount > 0){
            int size = q.size();

            for(int  i = 0; i<size; i++){
                int[] node= q.poll();
                int row = node[0];
                int col = node[1];

                for(int[] direc : directions){
                    int r = row + direc[0];
                    int c = col + direc[1];

                    if(r < 0 || c<0 || r>=rows || c >= cols || grid[r][c]!=1){
                        continue;
                    }
                    
                    grid[r][c] = 2;
                    freshCount--;

                    q.offer(new int[]{r,c});
                    
                }
            }
            time++;
        }
        return freshCount == 0 ? time : -1;
    }
}
