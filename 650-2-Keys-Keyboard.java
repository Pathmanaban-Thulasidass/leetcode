class Solution {
    public int minSteps(int n) {
        return primefactorsSum(n);
    }

    public int primefactorsSum(int n){
        int sum = 0;
        while(n%2==0){
            sum += 2;
            n /= 2;
        }
        for(int i=3;i<=Math.sqrt(n);i += 2){
            while(n%i==0)
            {
                sum += i;
                n /= i;
            }
        }
        if(n > 2)
            sum += n;
        return sum;
    }
}