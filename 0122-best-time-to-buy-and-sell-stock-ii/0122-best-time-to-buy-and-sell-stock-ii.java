class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(prices[i] < prices[i+1]){
                min = Math.min(min,prices[i]);
            }
            else{
                if(min != Integer.MAX_VALUE)
                    profit += (prices[i] - min);
                min = Integer.MAX_VALUE;
            }
        }
        if(min != Integer.MAX_VALUE){
            profit += prices[n-1] - min;
        }
        return profit;
    }
}