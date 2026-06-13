class Solution {
    public double myPow(double x, int n) {
        //bitwise exponential.

        if(x==0) return 0;
        if(n==0) return 1;

        long N = n;

        if(N < 0){
            x = 1/x;
            N = -N; //N becomes +ve
        }
        double res = 1.0;

        while(N>0){
            if((N & 1) == 1) //N is odd
            {
                res = res * x;
            }

            x =  x * x;
            N = N >>1;
        }

        return res;
    }
}
