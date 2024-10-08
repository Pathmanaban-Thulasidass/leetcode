class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> monoSt = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!monoSt.isEmpty() && monoSt.peek() <= nums[i%n]){
                monoSt.pop();
            }
            if(i < n){
                if(monoSt.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = monoSt.peek();
            }
            monoSt.push(nums[i%n]);
        }
        return ans;
    }
}