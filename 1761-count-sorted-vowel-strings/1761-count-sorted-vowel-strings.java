class Solution {
    public int countVowelStrings(int n) {
        int ans = 0;
        int preSum[] = {1,2,3,4,5};
        for(int i=1;i<n;i++){
            int sum = 0;
            for(int j=0;j<5;j++){
                sum += preSum[j];
                preSum[j] = sum;
            }
        }
        return preSum[4];
    }
}