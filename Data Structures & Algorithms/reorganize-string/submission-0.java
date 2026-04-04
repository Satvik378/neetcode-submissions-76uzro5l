class Solution {
    public String reorganizeString(String s) {

        int[] countArr = new int[26];

        for(char c : s.toCharArray()){
            countArr[c-'a']++;
        }

        PriorityQueue<int[]> queue= new PriorityQueue<>((a,b) -> b[0]-a[0]);
        //max count element first , index

        for(int i = 0; i<26; i++){
            if(countArr[i] > 0){
                 queue.offer(new int[] {countArr[i], i});
            }
        }

        int[] prev = null;
        StringBuilder builder = new StringBuilder();

        while(!queue.isEmpty() || prev!=null){

            if(prev != null && queue.isEmpty()){
                return "";
            }
            
            int[] temp = queue.poll();
            builder.append((char) (temp[1] + 'a'));
            temp[0]--;

            if(prev!=null){
                queue.offer(prev);
                prev = null;
            }

            if(temp[0] > 0){
                prev = temp;
            }
        }
        return builder.toString();
    }
}