class Solution {
    public long coloredCells(int n) {
        long ans = 0;
        long mid = n + (n - 1);
        long temp = mid - 1;
        long total = (temp * (temp + 1)) / 2;
        long evenSum = ((temp / 2) * ((temp/2) + 1)); //2 * ((temp / 2) * ((temp/2) + 1)) / 2;
        long oddSum = total - evenSum;
        return (2 * oddSum) + mid; 
    }
}