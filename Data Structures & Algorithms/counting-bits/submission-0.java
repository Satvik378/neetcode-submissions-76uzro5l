class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];

        for(int i = 0; i<=n; i++){

            res[i] = noOfBits(i);
        }

        return res;
    }

    private int noOfBits(int n){
        int res = 0;

        while(n!=0){
            res+= (n&1) == 1 ? 1 : 0;
            n = n>>1;
        }
        return res;
    }
}
