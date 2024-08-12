class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(3);
    public int thirdMax(int[] nums) {
        for(int num:nums){
            add(num);
        }
        if(pq.size() == 2){
            pq.poll();
        }
        return pq.peek();
    }
    void add(int val){
        if(!pq.contains(val)){
            if(pq.size() == 3 && pq.peek() <= val){
                pq.poll();
                pq.add(val);
            }
            else if(pq.size() < 3){
                pq.add(val);
            }
        }
    }
}