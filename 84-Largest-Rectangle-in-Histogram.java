class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] nextSmallestEle = nextSmallestEleFun(heights);
        int [] previousSmallestEle = previousSmallestEleFun(heights);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max < heights[i] * (nextSmallestEle[i] - previousSmallestEle[i] - 1))
                max = heights[i] * (nextSmallestEle[i] - previousSmallestEle[i] - 1);
        }
        return max;
    }
    public int[] nextSmallestEleFun(int []nums){
        int n = nums.length;
        Stack<Integer> monoSt = new Stack<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!monoSt.isEmpty() && nums[monoSt.peek()] >= nums[i])
                monoSt.pop();
            if(monoSt.isEmpty())
                ans[i] = n;
            else
                ans[i] = monoSt.peek();
            monoSt.push(i);
        }
        return ans;
    }
    public int[] previousSmallestEleFun(int nums[]){
        int n = nums.length;
        int ans [] = new int[n];
        Stack<Integer> monoSt = new Stack<>();
        for(int i=0;i<n;i++){
            while(!monoSt.isEmpty() && nums[monoSt.peek()] > nums[i])
                monoSt.pop();
            if(monoSt.isEmpty())
                ans[i] = -1;
            else
                ans[i] = monoSt.peek();
            monoSt.push(i);
        }
        return ans;
    }
}