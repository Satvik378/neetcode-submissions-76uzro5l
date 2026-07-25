class Solution {
    //solving using pattern
    Map<String, List<String>> map;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        if(!wordList.contains(endWord)) return 0;

        wordList.add(beginWord);

        for(String word :  wordList){
            for(int i = 0; i<word.length(); i++){
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(word);
            }
        }

        //bfs as min number of words

        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int words = 1;

        q.offer(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                String current = q.poll();

                if(current.equals(endWord)) return words;

                for(int j = 0; j<current.length(); j++){

                    String pattern = current.substring(0,j) + "*"
                                        +current.substring(j+1);

                    for(String nei : map.get(pattern)){
                        //we get the strings which are one char apart.
                        if(!visited.contains(nei)){
                            q.offer(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
            words++;
        }

        return 0;
    }
}
