class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        //similar logic to previous question
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum%k !=0) return false;

        int perSubsetSum = sum/k;
        
        //pruning 
        Arrays.sort(nums);
        for(int i = 0, j=nums.length-1; i<j; i++, j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[i] = temp;
        }

        return dfs(nums, k, perSubsetSum, 0, new int[k]);
    }

    private boolean dfs(int[] nums, int k, int perSubsetSum, int index, int[] subsetSum){

        if(index == nums.length) return true;

        for(int i = 0; i<k; i++){
            if(subsetSum[i] + nums[index] <= perSubsetSum){
                subsetSum[i] += nums[index];
                if(dfs(nums, k, perSubsetSum, index+1, subsetSum)) return true;
                subsetSum[i]-= nums[index];
            }

            if(subsetSum[i] == 0) break;
        }

        return false;
    }
}