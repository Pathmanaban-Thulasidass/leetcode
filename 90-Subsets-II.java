class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subSetRecur(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void subSetRecur(int index,int nums[],List<Integer> inner,List<List<Integer>> ans){
        ans.add(new ArrayList<>(inner));
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            inner.add(nums[i]);
            subSetRecur(i + 1,nums,inner,ans);
            inner.remove(inner.size() - 1);
        }
    }
}