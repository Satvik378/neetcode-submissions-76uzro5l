class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){

            if(hmap.get(target-nums[i])!=null){
                return new int[]{hmap.get(target-nums[i]), i}; 
            }
            else{
                hmap.put(nums[i], i);
            }
        }

        return null;

    }
}
