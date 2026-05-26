/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        int prevEnd = 0;

        if (intervals != null && !intervals.isEmpty()) {
            prevEnd = intervals.get(0).end;
        }

        for(int i = 1; i<intervals.size(); i++){

            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if(prevEnd > start){
                return false;
            }
            prevEnd = end;
        }

        return true;
    }
}
