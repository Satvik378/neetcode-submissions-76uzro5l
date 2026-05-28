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
    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, (a,b) -> a.start-b.start);
        //intervals sorted based on start time.
        //now we would need a room if another meeting starts 
        //and previous meeting is still gng on therefore we need
        //end time tracking as well.

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){

            if(!minHeap.isEmpty() && minHeap.peek()<= interval.start){
                //we can reuse the room.
                minHeap.poll();
            }

            minHeap.offer(interval.end);
        } 

        return minHeap.size();
    }
}
