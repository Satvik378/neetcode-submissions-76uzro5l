class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]);
        //range, endTime

        int index = 0;

        HashMap<Integer, Integer> res = new HashMap<>();
        //query, interval range.

        for(int query : Arrays.stream(queries).sorted().toArray()){
            //this creates a copy of queries in sorted order.
            while(index < intervals.length && intervals[index][0] <= query){
                minHeap.offer(new int[]{
                    intervals[index][1] - intervals[index][0] +1 , intervals[index][1]}
                );
                index++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query){
                minHeap.poll();
            }

            res.put(query, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            ans[i] = res.get(queries[i]);
        }

        return ans;
    }
}
