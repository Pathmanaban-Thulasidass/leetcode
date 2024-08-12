class KthLargest {

    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() == 0){
            pq.add(val);
        }
        else if(pq.size() == k && pq.peek() <= val){
                pq.poll();
                pq.add(val);
        }
        else if(pq.size() < k){
            pq.add(val);
        }
        return pq.peek();
    }
}