class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(0,0,n);
    }
    public boolean helper(int pow,long sum,int n){
        if(pow == 17){
            return sum == n;
        }
        if(sum == n)
            return true;
        boolean pick = helper(pow + 1,(sum + (long)Math.pow(3,pow)),n);
        if(pick){
            return true;
        }
        boolean notPick = helper(pow + 1,sum, n);
        return notPick;
    }
}