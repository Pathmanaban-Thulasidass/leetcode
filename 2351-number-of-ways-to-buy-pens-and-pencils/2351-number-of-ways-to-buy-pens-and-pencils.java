class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for(int pens=0;pens * cost1 <= total;pens++){
            long penPrices = (pens * cost1);
            long temp = (total - penPrices) / cost2;
            ans += temp + 1;
        }        
        return ans;
    }
}