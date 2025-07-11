class Twitter {
    int postNo = 0;
    Map<Integer,Set<Integer>> followMap;
    Map<Integer,Set<int[]>> postMap;
    public Twitter() {
        postNo = 0;
        followMap = new HashMap<>();
        postMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        postNo++;
        postMap.putIfAbsent(userId,new HashSet<>());
        postMap.get(userId).add(new int[]{tweetId,postNo});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> userPosts = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        Set<Integer> friends = followMap.get(userId);
        Set<int[]> selfPost = postMap.get(userId);
        if(selfPost != null){
            for(int[] post : selfPost){
                pq.add(post);
            }
        }
        if(friends != null){
            for(int friend : friends){
                if(postMap.get(friend) != null){
                    for(int[] post : postMap.get(friend)){
                        pq.add(post);
                    }
                }
            }
        }
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            count++;
            userPosts.add(pq.poll()[0]);
        }
        return userPosts;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId) != null)
            followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */