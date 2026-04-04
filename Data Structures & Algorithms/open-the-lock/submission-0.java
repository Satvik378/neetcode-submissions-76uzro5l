class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        if(visited.contains("0000"))return -1;

        int turns = 0;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i<size; i++){
                String str = q.poll();
                if(str.equals(target)) return turns;

                //put in q the various combination of str
                for(String c: children(str)){

                    if(!visited.contains(c)){
                        visited.add(c);
                        q.offer(c);
                    }
                    
                }
            }
            turns++;
        }
        
        return -1;
    }

    private List<String> children(String str){

        List<String> res = new ArrayList<>();

        for(int i = 0; i<4; i++){
            //add logic
            char[] c = str.toCharArray();
            c[i] = (char)(((c[i]-'0' + 1)%10) + '0');
            res.add(new String(c));

            //sub logic
            c = str.toCharArray();
            c[i] = (char)(((c[i] - '0' -1 +10)%10) + '0');
            res.add(new String(c));
        }

        return res;
    }
}