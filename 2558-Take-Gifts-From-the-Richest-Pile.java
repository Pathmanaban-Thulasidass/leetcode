class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<n;i++){
            pq.add(gifts[i]);
        }
        for(int i=0;i<k;i++){
            pq.add((int)Math.sqrt((double)pq.poll()));
        }
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}