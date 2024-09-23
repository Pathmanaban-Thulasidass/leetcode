class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void findCombination(int index,int []nums,int target,List<List<Integer>> ans,List<Integer> inner){
        if(target == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(index == nums.length)
            return;
        if(nums[index] <= target){
            inner.add(nums[index]);
            findCombination(index,nums,target-nums[index],ans,inner);
            inner.remove(inner.size() - 1);
        }
        findCombination(index + 1,nums,target,ans,inner);
    }
}