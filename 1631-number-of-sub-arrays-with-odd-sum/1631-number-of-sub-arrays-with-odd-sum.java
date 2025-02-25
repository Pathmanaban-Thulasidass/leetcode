class Solution {
    final int MOD = (int) 1e9 + 7;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long preSum = 0;
        int oddCount = 0;
        int evenCount = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            preSum += arr[i];
            if(preSum % 2 != 0){
                ans++;
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
            else{
                ans = (ans + oddCount) % MOD;
                evenCount++;
            }
        }
        return ans;
    }
}