class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int noOfPiles = n / 3;
        int total = 0;
        Arrays.sort(piles);
        int i = n - 2;
        while(noOfPiles > 0){
            total += piles[i];
            i -= 2;
            noOfPiles--;
        }
        return total;
    }
}