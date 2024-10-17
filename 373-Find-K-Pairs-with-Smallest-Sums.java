class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        for(int i=0;i<n1 && i<k;i++){
            pq.add(Arrays.asList(nums1[i],nums2[0],0));
        }
        while(k > 0 && !pq.isEmpty()){
            k--;
            List<Integer> curr = pq.poll();
            ans.add(Arrays.asList(curr.get(0),curr.get(1)));

            if(curr.get(2) == n2 - 1)
                continue;
            
            pq.add(Arrays.asList(curr.get(0),nums2[curr.get(2) + 1],curr.get(2) + 1));
        }
        return ans;
    }
}