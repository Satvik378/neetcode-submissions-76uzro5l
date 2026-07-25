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

    int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    boolean union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

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
        HashMap<String, Integer> emailToAccindex = new HashMap<>();

        DSU dsu = new DSU(n);

        for(int i = 0; i<n; i++){
            for(int j = 1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(emailToAccindex.containsKey(email)){
                    dsu.union(i, emailToAccindex.get(email));
                }
                else{
                    emailToAccindex.put(email, i);
                }
            }
        }

        HashMap<Integer, List<String>> accToEmail = new HashMap<>();

        for(Map.Entry<String, Integer> entry : emailToAccindex.entrySet()){
            String email = entry.getKey();
            int accIndex = entry.getValue();

            int leader = dsu.find(accIndex);

            accToEmail.putIfAbsent(leader, new ArrayList<>());
            accToEmail.get(leader).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : accToEmail.entrySet()){

            String accountName = accounts.get(entry.getKey()).get(0);
            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(accountName);
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }
}