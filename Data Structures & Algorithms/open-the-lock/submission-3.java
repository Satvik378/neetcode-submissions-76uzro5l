class Solution {
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> visited = new HashSet<>();

        for(String deadend: deadends){
            visited.add(deadend);
        }
        //min number of turns.
        //bfs
        if(visited.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int turns = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                String current = q.poll();

                if(current.equals(target)) return turns;

                for(String comb : combination(current)){
                    if(!visited.contains(comb)){
                        visited.add(comb);
                        q.offer(comb);
                    }
                }
            }
            turns++;
        }

        return -1;
    }

    private List<String> combination(String str){
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i<4; i++){
            char[] c = str.toCharArray();
            //addition
            c[i] = (char)(((c[i] - '0') + 1)%10 + '0');
            res.add(new String(c));

            c = str.toCharArray();
            c[i] = (char)(((c[i] - '0') -1 + 10)%10 + '0');
            res.add(new String(c));
        }

        return res;
    }
}