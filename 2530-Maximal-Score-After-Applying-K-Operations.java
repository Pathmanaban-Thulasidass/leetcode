class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int temp = pq.remove();
            sum += temp;
            pq.add((int)Math.ceil((double)temp / 3));
        }
        return sum;
    }
}