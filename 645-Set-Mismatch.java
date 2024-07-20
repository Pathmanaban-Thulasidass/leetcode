class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2];
        int totalSum = (n*(n+1))/2;
        int repeatingEle = 0;
        int arrSum = 0;
        boolean found[] = new boolean[n+1];
        for(int i=0;i<n;i++){
            if(found[nums[i]]){
                repeatingEle = nums[i];
            }
            found[nums[i]] = true;
            arrSum += nums[i];
        }
        ans[0] = repeatingEle;
        ans[1] = totalSum - (arrSum - repeatingEle);
        return ans;
    }
}