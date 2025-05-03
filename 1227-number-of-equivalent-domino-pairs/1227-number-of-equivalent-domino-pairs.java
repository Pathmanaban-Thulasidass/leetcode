class Solution {
    final int MOD = (int)(1e9 + 7);
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int freq[][] = new int[10][10];
        int ans = 0;
        for(int i=0;i<n;i++){
            int a = Math.min(dominoes[i][0],dominoes[i][1]);
            int b = Math.max(dominoes[i][0],dominoes[i][1]);
            freq[a][b]++;
        }
        for(int i=1;i<10;i++){
            for(int j=1;j<10;j++){
                int temp = freq[i][j];
                if(temp > 0){
                    ans = (ans + ((temp * (temp - 1)) / 2) % MOD)%MOD;
                }
            }
        }
        return ans;
    }
}