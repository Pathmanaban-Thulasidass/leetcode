class FindSumPairs {

    int nums1[];
    int nums2[];
    Map<Integer,Integer> map = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int val : nums2){
            map.put(val,map.getOrDefault(val,0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int temp = nums2[index];
        int freq = map.get(temp);
        map.put(temp,freq - 1);
        if(freq == 0){
            map.remove(temp);
        }
        map.put(temp + val,map.getOrDefault(temp + val,0) + 1);
        nums2[index] += val;
    }
    
    public int count(int tot) {
        int count = 0;
        int n = nums1.length;
        for(int i=0;i<n;i++){
            int tar = tot - nums1[i];
            if(map.get(tar) != null){
                count += map.get(tar);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */