class Solution {
    public String predictPartyVictory(String senate) {
        
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for(int i = 0; i<senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }
            else if(senate.charAt(i) == 'D'){
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if(rIndex < dIndex){
                radiant.offer(rIndex + senate.length());
            }
            else{
                dire.offer(dIndex + senate.length());
            }
        }

        return radiant.size() > 0 ? "Radiant" : "Dire";
    }
}