class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int ans = 1;
        String prevOp = "";

        while(right < arr.length){

            if(!"<".equals(prevOp) && arr[right-1] < arr[right]){
                ans = Math.max(ans, right-left +1);
                right++;
                prevOp = "<";
            }
            else if(!">".equals(prevOp) && arr[right-1] > arr[right]){
                ans = Math.max(ans, right-left +1);
                right++;
                prevOp = ">";
            }
            else{
                right = (arr[right] == arr[right-1]) ? right+1 : right;
                left  = right-1;
                prevOp = "";
            }
        }

        return ans;
    }
}