class DSU{
    int[] parent;
    int[] rank;
    
    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int node){
        if(node!=parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int edge1, int edge2){
        int p1 = find(edge1);
        int p2 = find(edge2);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];

        }
        else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    } 
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> emailToAccIndex = new HashMap<>();

        for(int i = 0; i<n; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){

                String email = accounts.get(i).get(j);

                if(emailToAccIndex.containsKey(email)){
                    //this email exists with another acc as well.
                    dsu.union(i,emailToAccIndex.get(email));
                }
                else{
                    emailToAccIndex.put(email, i);
                }

            }
        }

        //now we have to get accIndex -> emails
        HashMap<Integer, List<String>> accToEmails = new HashMap<>();

        for(Map.Entry<String, Integer> entry : emailToAccIndex.entrySet()){

            String email = entry.getKey();
            int accIndex = entry.getValue();

            int leader = dsu.find(accIndex);

            accToEmails.putIfAbsent(leader, new ArrayList<>());
            accToEmails.get(leader).add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry : accToEmails.entrySet()){

            String account = accounts.get(entry.getKey()).get(0);
            List<String> emails = entry.getValue(); 

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(account);
            temp.addAll(emails);
            
            res.add(temp);
        }

        return res;

    }
}