class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        //the ans will be the AND of common prefix between two numbers.
        //rest all will be 0.
        //we shift the bit till we find this common prefix.
        int counter = 0;
        while(left != right){
            left >>= 1;
            right >>= 1;
            counter++;
        }

        return left << counter;

    }
}