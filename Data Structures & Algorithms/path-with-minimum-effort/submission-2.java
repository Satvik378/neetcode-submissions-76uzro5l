class Solution {
    public int minimumEffortPath(int[][] heights) {
       int rows = heights.length;
       int cols = heights[0].length;

       int[][] directions = {{-1,0}, {0,1}, {0,-1}, {1,0}};

       //Dijkstras + backtracking
       //dijkstras -> BFS + priorityQueue

       PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
       
       int[][] dist = new int[rows][cols];
       for(int i = 0; i<rows; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

       q.offer(new int[]{0,0,0}); //diff, r, c
       //visited[0][0] = true;

       while(!q.isEmpty()){
            int[] current = q.poll();

            int maxDist = current[0];
            int row = current[1];
            int col = current[2];

            if(row == rows-1 && col == cols-1) return maxDist;

            if(maxDist > dist[row][col]) continue; 

            for(int[] direction : directions){
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;

                if(newRow < rows && newCol < cols && newRow >=0 && newCol >=0){
                    int newDist = Math.max(maxDist, 
                        Math.abs(heights[row][col] - heights[newRow][newCol]));

                    if(newDist < dist[newRow][newCol]){
                        dist[newRow][newCol] = newDist;

                        q.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
       }

       return -1;


    }
}