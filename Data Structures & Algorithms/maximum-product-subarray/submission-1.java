class Solution {
    public int maxProduct(int[] nums) {
        //kadane's algo
        //maintain min product subaray and max product subarray
        int currentMax = 1;
        int currentMin = 1;
        int res = Integer.MIN_VALUE;

        for(int i : nums){
            res = Math.max(res, i); //if only one element in the array.
        }

        for(int num : nums){

            if(num == 0){
                currentMax = 1;
                currentMin = 1;
                continue;
            }

            int tempMax = currentMax;
            int tempMin = currentMin;

            currentMax = Math.max(num, Math.max(num * tempMax, num * tempMin));
            currentMin = Math.min(num, Math.min(num * tempMax, num * tempMin));

            res = Math.max(res, currentMax);
        }

        return res;


    }
}
