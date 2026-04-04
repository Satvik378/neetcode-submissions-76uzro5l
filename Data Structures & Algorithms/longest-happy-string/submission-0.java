class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y) -> y[0]-x[0]);

        if(a > 0){
            queue.offer(new int[]{a, 'a'});
        }
        if(b > 0){
            queue.offer(new int[]{b, 'b'});
        }
        if(c > 0){
            queue.offer(new int[]{c, 'c'});
        }

        StringBuilder builder = new StringBuilder();

        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();

            if(builder.length() > 1 && builder.charAt(builder.length()-1) == curr[1] 
            && builder.charAt(builder.length()-2) == curr[1]){
                
                if(queue.isEmpty()){
                    break;
                }
                //we need another char now.
                int[] second = queue.poll();
                
                builder.append((char)second[1]);
                second[0]--;

                if(second[0] > 0){
                    queue.offer(second);
                }

                queue.offer(curr);
            }
            else{
                builder.append((char)curr[1]);
                curr[0]--;
                if(curr[0] > 0){
                    queue.offer(new int[]{curr[0], curr[1]});
                }
            }
            

        }

        return builder.toString();
    }
}