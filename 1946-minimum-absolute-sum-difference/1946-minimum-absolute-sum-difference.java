import java.util.*;

class Solution {
    final int MOD = (int) 1e9 + 7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans = 0;
        int maxGain = 0;
        int[] sortedNums1 = Arrays.copyOf(nums1, n);
        Arrays.sort(sortedNums1);
        for (int i = 0; i < n; i++) {
            int absDiff = Math.abs(nums1[i] - nums2[i]);
            ans = (ans + absDiff) % MOD;
            int[] closest = binarySearch(0, n - 1, nums2[i], sortedNums1);
            int minReplacementDiff = Math.min(
                Math.abs(closest[0] - nums2[i]), 
                Math.abs(closest[1] - nums2[i])
            );
            maxGain = Math.max(maxGain, absDiff - minReplacementDiff);
        }
        return (ans - maxGain + MOD) % MOD; 
    }

    public int[] binarySearch(int low, int high, int val, int[] nums) {
        int lowVal = Integer.MIN_VALUE;
        int highVal = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == val) {
                return new int[]{nums[mid], nums[mid]};
            } else if (nums[mid] < val) {
                lowVal = nums[mid];
                low = mid + 1;
            } else {
                highVal = nums[mid];
                high = mid - 1;
            }
        }
        return new int[]{lowVal, highVal};
    }
}
