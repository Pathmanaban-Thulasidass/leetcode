class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        HashSet<Integer> uni = new HashSet<Integer>();
        for(int i=0;i<=nums.size();i++){
            for(int j=i;j<nums.size();j++){
                uni.add(nums.get(j));
                ans += (uni.size() * uni.size());
            }
            uni.clear();
        }
        return ans;
    }
}