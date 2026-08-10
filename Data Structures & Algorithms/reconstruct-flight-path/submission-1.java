class Solution {
    HashMap<String, PriorityQueue<String>> adj;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();

        for(List<String> ticket : tickets){
            String from  = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }
        
        res = new ArrayList<>();
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String src) {
    PriorityQueue<String> pq = adj.get(src);

    while (pq != null && !pq.isEmpty()) {
        String nei = pq.poll(); //as we have remove them
        dfs(nei);
    }

    res.add(src);
    }
}
