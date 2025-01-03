class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Deque<int[]> monoQueue = new LinkedList<>();
        int left = 0;
        for(int i=0;i<k;i++){
            while(!monoQueue.isEmpty() && monoQueue.peekLast()[0] < nums[i]){
                monoQueue.pollLast();
            }
            monoQueue.addLast(new int[]{nums[i],i});           
        }
        ans[0] = monoQueue.peek()[0];
        for(int i=k;i<n;i++){
            if(i == monoQueue.peekFirst()[1] + k){
                monoQueue.poll();
            }
            while(!monoQueue.isEmpty() && monoQueue.peekLast()[0] < nums[i]){
                monoQueue.pollLast();
            }
            monoQueue.addLast(new int[]{nums[i],i}); 
            ans[i-k+1] = monoQueue.peek()[0];
        }
        return ans;
    }
}