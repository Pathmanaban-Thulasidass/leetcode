class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int totalWater = 0;
        //Left Max
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(height[i-1],leftMax[i-1]);
        } 
        //Right Max
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(height[i+1],rightMax[i+1]);
        }
        for(int i=0;i<n;i++){
            if(height[i] < leftMax[i] && height[i] < rightMax[i])
                totalWater += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return totalWater;
    }
}