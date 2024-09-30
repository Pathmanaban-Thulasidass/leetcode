import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[n];
        return canPartition(nums, visited, 0, 0, target, k);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int index, int curSum, int target, int k) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return canPartition(nums, visited, 0, 0, target, k - 1);
        }
        for (int i = index; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (canPartition(nums, visited, i + 1, curSum + nums[i], target, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
