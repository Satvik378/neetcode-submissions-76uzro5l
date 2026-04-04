class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];

        for(int i = 0; i<order.length(); i++){
            orderIndex[order.charAt(i) - 'a'] = i;
        }

        for(int index = 0; index<words.length-1; index++){

            String w1 = words[index];
            String w2 = words[index+1];

            for(int i = 0; i<w1.length(); i++){
                if(i == w2.length()) return false;
                if(w1.charAt(i)!= w2.charAt(i)){
                    if(orderIndex[w1.charAt(i)-'a'] - orderIndex[w2.charAt(i)-'a'] > 0 ) 
                        return false;
                    break;
                }
            }
        }

        return true;

    }
}