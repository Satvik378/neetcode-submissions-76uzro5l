class Twitter {

    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    int timeOfTweet;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timeOfTweet = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        List<int[]> tweets = tweetMap.get(userId);
        tweets.add(new int[] { timeOfTweet, tweetId });
        tweetMap.put(userId, tweets);
        timeOfTweet++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> b[0]- a[0]);

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for(int followeeId : followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                //for each of these followee's get the latest tweets
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);

                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
            
        }

        while(!minHeap.isEmpty() && res.size() < 10){
            int[] curr = minHeap.poll();
            res.add(curr[1]);

            int index = curr[3];
            
            //now if the user has more tweets
            if(index > 0){
                int[] tweet = tweetMap.get(curr[2]).get(index-1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index-1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<>());
        }
        
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
