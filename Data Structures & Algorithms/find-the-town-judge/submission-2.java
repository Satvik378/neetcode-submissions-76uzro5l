class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> incomingEdges = new HashMap<>();
        HashMap<Integer, Integer> outgoingEdges = new HashMap<>();

        for(int i = 1; i<=n; i++){
            incomingEdges.put(i, 0);
            outgoingEdges.put(i,0);
        }


        for(int[] temp : trust){
            int incoming = temp[0];
            int outgoing = temp[1];

            incomingEdges.put(outgoing, incomingEdges.getOrDefault(outgoing, 0)+1);
            outgoingEdges.put(incoming, outgoingEdges.getOrDefault(incoming, 0)+1);
        }

        for(int i = 1; i<=n; i++){
            if(incomingEdges.containsKey(i) && outgoingEdges.containsKey(i)){
                if(incomingEdges.get(i) == n-1 && outgoingEdges.get(i) == 0){
                    return i;
                }
            }
        }

        return -1;
    }
}