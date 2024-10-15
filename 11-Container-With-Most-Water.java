class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int min = Math.min(height[left],height[right]);
            max = Math.max(max,(right - left) * min);
            if(height[left] < height[right]){
                left++;
            }
            else
                right--;
        }
        return max;
    }
}