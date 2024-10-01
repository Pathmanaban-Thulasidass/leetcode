class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        generateSeq(0,nums.length,nums,new ArrayList<>(),ans);
        return new ArrayList<>(ans);
    }
    public void generateSeq(int index,int n,int[] nums,List<Integer> inner,Set<List<Integer>> ans){
        if(inner.size() > 1)
            ans.add(new ArrayList<>(inner));
        if(index == n){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (inner.isEmpty() || nums[i] >= inner.get(inner.size() - 1)) {
                inner.add(nums[i]);
                generateSeq(i + 1,n, nums, inner, ans);
                inner.remove(inner.size() - 1);
            }
        }
    }
}