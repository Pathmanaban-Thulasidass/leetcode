class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        int right = 0;
        int max = Integer.MIN_VALUE;
        int zeros = 0;
        while(right < n){
            if(nums[right] == 1){
                queue.add(1);
            }
            else{
                if(zeros < k){
                    queue.add(0);
                    zeros++;
                }
                else{
                    while(!queue.isEmpty() && queue.peek() != 0){
                        queue.poll();
                    }
                    queue.poll();
                    if(k != 0)
                        queue.add(0);
                }

            }
            max = Math.max(max,queue.size());
            right++;
        }
        return max;
    }
}