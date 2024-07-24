class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        recurPerumation(nums,stack,freq,ans);
        return ans;
    }
    public void recurPerumation(int nums[],List<Integer> stack,boolean[] freq,List<List<Integer>> ans){
        if(stack.size() == nums.length){
            ans.add(new ArrayList<>(stack));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                stack.add(nums[i]);
                recurPerumation(nums,stack,freq,ans);
                freq[i] = false;
                stack.remove(stack.size() - 1);
            }
        }
    }
}