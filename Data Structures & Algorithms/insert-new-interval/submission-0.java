class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(newInterval!= null && newInterval[1] < start){
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
            else if(newInterval == null || newInterval[0] > end){
                res.add(interval);
            }
            else{
                //overlap
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(end, newInterval[1]);
            }
        }

        if(newInterval!=null) res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
