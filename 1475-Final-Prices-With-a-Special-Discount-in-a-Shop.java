class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        int flag = 0,k=0;
        for(int i=0;i<prices.length;i++){
            flag = 0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    arr[k++] = prices[i]-prices[j];
                    flag=1;
                    break;
                }
            }
            if(flag == 0){
                arr[k++] = prices[i];
            }
        }
        return arr;
    }
}