class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean isNine = digits[n-1] == 9;
        if(digits[n-1] < 9){
            digits[n-1]++;
            return digits;
        }
        for(int i=n-1;i>=0;i--){
            if(isNine && digits[i] == 9){
                digits[i] = 0;
            }
            else if(digits[i] != 9 && isNine){
                digits[i]++; 
                isNine = false;
                break;
            }
        }
        if(isNine){
            int ans[] = new int[n+1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}