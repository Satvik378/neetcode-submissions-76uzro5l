class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        //bfs with farthest
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int farthest = 0;

        while(!q.isEmpty()){
            int currentIndex = q.poll();
            
            int start = Math.max(currentIndex+minJump, farthest + 1);

            for(int i = start; i<Math.min(currentIndex + maxJump + 1, s.length()); i++){

                if(s.charAt(i) == '0'){
                    q.offer(i);

                    if(i == s.length() -1){
                        return true;
                    }
                }
            }
            farthest = currentIndex + maxJump;
        }

        return false;
    }
}