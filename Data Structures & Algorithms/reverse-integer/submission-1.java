class Solution {
    public int reverse(int x) {
        
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while(x!=0){

            int temp = x%10;
            x = x/10;

            //check overflow conditions.
            if(res > max/10 || (res == max/10 && temp > max%10)){
                return 0;
            }

            if(res < min/10 || (res == min/10 && temp < min%10)){
                return 0;
            }

            res = (res * 10) + temp;
        }

        return res;
    }
}
