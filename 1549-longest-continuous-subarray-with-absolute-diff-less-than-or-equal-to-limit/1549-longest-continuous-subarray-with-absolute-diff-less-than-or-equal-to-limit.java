class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<int[]> monoQueueMax = new LinkedList<>();
        Deque<int[]> monoQueueMin = new LinkedList<>();
        monoQueueMax.add(new int[]{nums[0],0});
        monoQueueMin.add(new int[]{nums[0],0});
        int right = 1;
        int left = 0;
        int ans = 1;
        while(right < n){
            while(!monoQueueMax.isEmpty() && monoQueueMax.peekLast()[0] < nums[right]){
                monoQueueMax.pollLast();
            }
            monoQueueMax.addLast(new int[]{nums[right],right});
            while(!monoQueueMin.isEmpty() && monoQueueMin.peekLast()[0] > nums[right]){
                monoQueueMin.pollLast();
            }
            monoQueueMin.addLast(new int[]{nums[right],right});
            while(left <= right && !monoQueueMax.isEmpty() && !monoQueueMin.isEmpty() && (monoQueueMax.peekFirst()[0] - monoQueueMin.peekFirst()[0]) > limit){
                left++;
                while(!monoQueueMax.isEmpty()  && monoQueueMax.peekFirst()[1] < left){
                    monoQueueMax.pollFirst();
                }
                while(!monoQueueMin.isEmpty()  && monoQueueMin.peekFirst()[1] < left){
                    monoQueueMin.pollFirst();
                }
            }
            ans = Math.max(ans,right - left + 1);
            right++;
        }
        return ans;
    }
}