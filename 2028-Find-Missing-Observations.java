class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = m + n;
        int sum = 0;
        for(int i=0;i<m;i++){
            sum += rolls[i];
        }
        int requiredVal = (total * mean) - sum;
        if((requiredVal > 6 * n) || requiredVal < 0 || n > requiredVal){
            return new int[0];
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = 1;
        }
        int i = 0;
        requiredVal -= n;
        while(requiredVal > 0){
            if(requiredVal < 6){
                ans[i] += requiredVal;
                requiredVal = 0;
            }
            else{
                ans[i] += 5;
                requiredVal -= 5;
            }
            i++;
        }
        return ans;
    }
}