class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int dp[] = new int[n];
        int arr[] = new int[n];
        int maxIndex = -1;
        int maxValue = 0;
        Arrays.sort(nums);
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if((nums[i] % nums[j]) == 0){
                    if(max < dp[j]){
                        max = dp[j];
                        arr[i] = j;
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i] > maxValue){
                maxValue = dp[i];
                maxIndex = i;
            }
        }
        while(maxIndex != -1){
            ans.add(nums[maxIndex]);
            maxIndex = arr[maxIndex];
        }
        return ans;
    }
}