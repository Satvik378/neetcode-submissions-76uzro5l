class Solution {
    public int maxProduct(int[] nums) {
        //kadanes algo

        int currentMin = 1;
        int currentMax = 1;
        int res = Integer.MIN_VALUE;

        for(int i : nums){
            res = Math.max(res, i);
        }
        
        for(int i : nums){
            if(i == 0){
                currentMin = 1;
                currentMax = 1;
                continue;
            }
            else{
                int tempMin= currentMin;
                int tempMax = currentMax;
                
                currentMin = Math.min(i, Math.min(tempMin*i,
                                                            tempMax*i));
                currentMax = Math.max(i, Math.max(tempMax*i, 
                                                            tempMin*i));
            }

            res = Math.max(currentMax, res);
        }

        return res;
    }
}
