class Solution {
    public List<Integer> partitionLabels(String s) {
        //one char should appear in only one substring.
        //hashmap to store the last index of char.
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();

        int currParlen = 0;
        int end = 0;

        for(int i = 0; i<s.length(); i++){
            end = Math.max(end, map.get(s.charAt(i)));
            currParlen++;

            if(i == end){
                res.add(currParlen);
                currParlen = 0;
            }
        }

        return res;
    }
}
