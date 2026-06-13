class Solution {
    public int singleNumber(int[] nums) {
        
        //XOR with itself gives 0 and with 0 gives itself.

        int res = 0;

        for(int i : nums){
            res ^= i;
        }

        return res;
    }
}
