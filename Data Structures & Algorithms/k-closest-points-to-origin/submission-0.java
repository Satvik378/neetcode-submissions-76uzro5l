class Pair{
    long key;
    int[] value;
    
    Pair(long key, int[] value){
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //max heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a,b) -> Long.compare(b.key, a.key));

        for(int[] i : points){
            long distance = i[0]*i[0] + i[1]*i[1];

            queue.offer(new Pair(distance, i));

            if(queue.size() > k){
                queue.poll();
            }
        }

        int[][] res = new int[k][2];

        int index = 0;

        while(!queue.isEmpty()){
            int[] temp = queue.poll().value;

            res[index][0] = temp[0];
            res[index][1] = temp[1];

            index++;
        }

        return res;
    }
}
