class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(start, arr.length, arr, new boolean[arr.length]);
    }
    
    public boolean helper(int index, int n, int[] nums, boolean[] visited) {
        if (index < 0 || index >= n || visited[index]) {
            return false;
        }
        if (nums[index] == 0) {
            return true;
        }
        visited[index] = true; 

        // Move Forward and Backward
        boolean forward = helper(index + nums[index], n, nums, visited);
        boolean backward = helper(index - nums[index], n, nums, visited);
        visited[index] = false;

        return forward || backward;
    }
}
