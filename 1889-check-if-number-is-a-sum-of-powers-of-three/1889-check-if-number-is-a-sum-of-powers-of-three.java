class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(n);
    }
    public boolean helper(int n){
        if(n == 1)
            return true;
        if(n % 3 == 0){
            return helper(n / 3);
        }
        if((n - 1) % 3 == 0){
            return helper((n-1) / 3);
        }
        return false;
    }
}