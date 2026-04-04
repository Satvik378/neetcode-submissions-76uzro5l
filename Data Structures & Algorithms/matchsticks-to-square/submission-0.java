class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;

        for(int i : matchsticks){
            sum +=i;
        }

        if(sum%4 !=0) return false;

        int eachSideLen = sum/4;

        //pruning sorted in desc order.
        Arrays.sort(matchsticks);
        for(int i= 0,j=matchsticks.length-1; i<j; i++, j--){
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] sides=new int[4];
        //backtrack -> decision making
        return dfs(matchsticks,eachSideLen, 0, sides);
    }

    private boolean dfs(int[] matchsticks, int sideLen, int index, int[] sides){
        if(index == matchsticks.length){
            return true;
        }

        for(int side = 1; side <= 4; side++){
            if(sides[side-1] + matchsticks[index] <= sideLen){
                sides[side-1] += matchsticks[index];  
                if(dfs(matchsticks, sideLen, index+1, sides)) return true;
                sides[side-1] -= matchsticks[index];
            }
        }

        return false;
    }
}