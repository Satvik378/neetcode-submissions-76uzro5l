class Solution {
    public boolean isHappy(int n) {
        //slow pointer - fast pointer approach of linked list

        int fastPointer = sumOfSquare(n);
        int slowPointer = n;

        while(fastPointer!= slowPointer){
            slowPointer = sumOfSquare(slowPointer);
            fastPointer = sumOfSquare(fastPointer);
            fastPointer = sumOfSquare(fastPointer);
        }

        return fastPointer == 1;
    }

    int sumOfSquare(int n){
        int res = 0;
        while(n > 0){
            int temp = n%10;
            res += temp*temp; 
            n = n/10;
        }
        return res;
    }
}
