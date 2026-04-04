class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) return 0;

        wordList.add(beginWord);

        Map<String, List<String>> adj = new HashMap<>();

        for(String word : wordList){
            for(int i = 0; i<word.length(); i++){
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                adj.putIfAbsent(pattern, new ArrayList<>());
                adj.get(pattern).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        int res = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                String str = q.poll();

                if(str.equals(endWord)) return res;
                if(visited.contains(str)) continue;

                visited.add(str);

                for(int j = 0; j<str.length(); j++){
                    String pattern = 
                        str.substring(0,j) + "*" + str.substring(j+1);
                    
                    for(String nei : adj.get(pattern)){
                        if(!visited.contains(nei)){
                            q.offer(nei);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}
