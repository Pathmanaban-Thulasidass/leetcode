class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefixProd = 1;
        int sufixProd = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefixProd == 0)
                prefixProd = 1;
            if(sufixProd == 0)
                sufixProd = 1;
            
            prefixProd *= nums[i];
            sufixProd *= nums[n-i-1];

            max = Math.max(max,Math.max(prefixProd,sufixProd));
        }
        return max;
    }
}