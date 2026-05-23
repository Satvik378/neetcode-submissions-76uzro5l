class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;

        for(int i = 0; i<gas.length; i++){
            diff += gas[i] - cost[i];
        }

        if(diff < 0) return -1;

        //now we know that solution is reachable therefore we have to find start index now.

        int res = 0;
        int total = 0;

        for(int i = 0 ; i<gas.length; i++){

            total += gas[i] - cost[i];

            if(total < 0){
                total = 0;
                res = i+1;
            }
        }

        return res;
    }
}
