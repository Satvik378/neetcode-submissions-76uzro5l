class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> incoming  = new HashMap<>();
        HashMap<Integer, Integer> outgoing = new HashMap<>();


        for(int i= 0; i<trust.length; i++){
            incoming.put(trust[i][1], incoming.getOrDefault(trust[i][1], 0)+1);
            outgoing.put(trust[i][0], outgoing.getOrDefault(trust[i][0], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : incoming.entrySet()){
            if(!outgoing.containsKey(entry.getKey()) && entry.getValue() == n-1){
                return entry.getKey();
            }
        }

        return -1;
    }
}