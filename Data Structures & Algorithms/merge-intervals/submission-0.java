class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        //sorted intervals

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i <intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int lastEnd = res.get(res.size()-1)[1];

            if(lastEnd >= start){
                //we have to merge these two intervals
                //upate the end of res interval.
                res.get(res.size()-1)[1] = Math.max(lastEnd, end);
            }
            else{
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
