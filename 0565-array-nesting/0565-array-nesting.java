class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean visited[] = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!visited[nums[i]]){
                ans = Math.max(ans,helper(i,nums,visited));
            }
        }
        return ans;
    }
    public int helper(int index,int[] nums,boolean visited[]){
        visited[index] = true;
        int count = 0;
        if(!visited[nums[index]]){
            count += helper(nums[index],nums,visited);
        }
        return count + 1;
    }

}