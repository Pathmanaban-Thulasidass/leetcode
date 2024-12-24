class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        boolean [] sieveOfEr = new boolean[n + 1];
        int count = 1;
        int i = 2;
        while(i < n){
            sieveOfEr[i] = true;
            i += 2;
        }
        for(i=3;i<n;i++){
            if(sieveOfEr[i] == false){
                count++;
                for(int j=i;j<n;j+=i){
                    sieveOfEr[j] = true;
                }
            }
        }
        return count;
    }
}