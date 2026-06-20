class Solution {
    public int reverseBits(int n) {
        
        int res = 0;

        for(int i = 0; i<32; i++){

            res = res << 1;
            //make space for next bit.

            res |= (n&1);

            n = n>>1;
        }

        return res;
    }
}
