class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> inner = new ArrayList<>();
        subSetRecur(0,nums,inner,ans);
        return new ArrayList<>(ans);
    }
    public void subSetRecur(int index,int nums[],List<Integer> inner,Set<List<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(inner));
            return;
        }
        //take
        inner.add(nums[index]);
        subSetRecur(index + 1,nums,inner,ans);
        //dont take
        inner.remove(inner.size() - 1);
        subSetRecur(index + 1,nums,inner,ans);
    }
}