class Solution {
    public double myPow(double x, int n) {
        if(x == 1)
            return 1;
        if(n > 0)
            return sqrt(x,n,x);
        else if(n == 0)
            return 1;
        return 1/sqrt(x,(long)n*-1,x);
    }
    public double sqrt(double x,long n,double ans){
        if(n == 1)
            return ans;
        if(n % 2 == 0){
            return sqrt(x*x,n/2,ans * x);
        }
        else{
            return x * sqrt(x*x,n/2,ans * x);
        }
    }
}