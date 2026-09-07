class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        q.offer(new int[]{0,0,0});

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];

        for(int i = 0; i<rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);


        while(!q.isEmpty()){
            int[] current = q.poll();

            int diff = current[0];
            int row = current[1];
            int col = current[2];

            if(row == rows-1 && col == cols-1) return diff;

            if(diff > dist[row][col]) continue;

            for(int[] direction : directions){
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if(newRow >=0 && newCol >=0 && newRow < rows && newCol < cols){
                    int newDiff = Math.max(diff, 
                        Math.abs(heights[newRow][newCol] - heights[row][col]));
                    
                    if(newDiff < dist[newRow][newCol]){
                       dist[newRow][newCol] = newDiff;

                       q.offer(new int[]{newDiff, newRow, newCol}); 
                    }
                }
            }
        }
        return 0;
    }
}