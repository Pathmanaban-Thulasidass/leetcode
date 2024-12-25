class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int nines = 0;
        int rem = 1;
        for(int i=0;i<n;i++){
            if(digits[i] == 9)
                nines++;
            else
                break;
        }
        if(nines == n){
            int ans[] = new int[n+1];
            ans[0] = 1;
            return ans;
        }
        for(int i=n-1;i>=0;i--){
            int sum = rem + digits[i];
            digits[i] = sum % 10;
            rem = sum / 10;
        }
        return digits;
    }
}