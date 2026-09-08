class Solution {
    public int swimInWater(int[][] grid) {
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int n = grid.length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[]{grid[0][0],0,0});

        while(!q.isEmpty()){

            int[] current = q.poll();
            int dist = current[0];
            int row = current[1];
            int col = current[2];

            if(row == n-1 && col == n-1) return dist;

            if(visited[row][col]) continue;

            visited[row][col] = true;

            for(int[] direction : directions){
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if(newRow >=0 && newRow < n && newCol >=0 && newCol < n 
                && !visited[newRow][newCol]){
                    q.offer(new int[]{Math.max(dist, grid[newRow][newCol]), newRow, newCol});
                }
            }
            
        }

        return -1;

    }
}
