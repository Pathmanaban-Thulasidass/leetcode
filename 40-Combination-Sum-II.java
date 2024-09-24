class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void findCombination(int index,int []nums,int target,List<List<Integer>> ans,List<Integer> inner){
        if(target == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;

            inner.add(nums[i]);
            findCombination(i+1,nums,target - nums[i],ans,inner);
            inner.remove(inner.size() - 1);
        }
    }
}