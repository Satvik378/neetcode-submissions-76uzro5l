class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        int prevEnd = intervals[0][1];
        int res = 0;

        for(int i = 1; i<intervals.length;i++){

            int start = intervals[i][0];
            int end = intervals[i][1];

            if(prevEnd > start){
                //overlapping intervals
                prevEnd = Math.min(prevEnd, end);
                res++;
            }
            else{
                prevEnd = end;
            }
        }

        return res;
    }
}
