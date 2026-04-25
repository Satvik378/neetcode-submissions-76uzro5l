class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;

        int product  = 1;
        while(n > 4){
            product *= 3; //3 maximizes product
            n -= 3;
        }

        return product * n;
    }
}