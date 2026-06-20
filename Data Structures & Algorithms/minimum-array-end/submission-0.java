class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        //start with x.

        for(int i= 0; i<n-1; i++){

            res +=1;
            res |= x;

        }

        return res;
    }
}