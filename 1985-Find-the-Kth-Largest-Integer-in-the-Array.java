import java.math.BigInteger;

class Solution {
    int k;
    PriorityQueue<BigInteger> pq;

    public String kthLargestNumber(String[] nums, int k) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            add(new BigInteger(nums[i]));
        }
        return pq.peek().toString();
    }

    public void add(BigInteger val) {
        if (pq.size() == k && pq.peek().compareTo(val) <= 0) {
            pq.poll();
            pq.add(val);
        } else if (pq.size() < k) {
            pq.add(val);
        }
    }
}
