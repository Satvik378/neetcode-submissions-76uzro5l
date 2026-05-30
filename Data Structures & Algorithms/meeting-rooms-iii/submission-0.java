class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>();
        
        PriorityQueue<long[]> used = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : 
                                    Long.compare(a[0], b[0]));
        //endTime, room.

        //at start all rooms are available
        for(int i = 0; i<n; i++){
            available.offer(i);
        }

        int[] rooms = new int[n];

        for(int[] meeting : meetings){

            long start = meeting[0];
            long end = meeting[1];

            while(!used.isEmpty() && used.peek()[0] <= start){
                //clearing all used rooms that became empty now.
                long[] temp = used.poll();
                available.offer((int)temp[1]);
            }

            if(!available.isEmpty()){
                int room = available.poll();
                rooms[(int)room]++; //its holding one more meeting
                used.offer(new long[]{end, room});
            }
            else{
                //there are no empty rooms available.
                //now the meeting is delayed with the duration 
                //till the used room becomes available.
                long[] temp = used.poll();

                long room = temp[1];
                long duration = meeting[1] - meeting[0];
                long newEnd = temp[0] + duration;

                rooms[(int)room]++;

                used.offer(new long[]{newEnd, room});
            }
        }

        int res = 0;

        for (int i = 1; i < n; i++) {
            if (rooms[i] > rooms[res]) {
                res = i;
            }
        }

        return res;
    }
}