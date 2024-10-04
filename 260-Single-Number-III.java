class Solution {
    public int[] singleNumber(int[] nums) {
        int totalXor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalXor ^= nums[i];
        }
        int rightmostSetBit = totalXor & (-totalXor);
        int bucket1 = 0;
        int bucket2 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & rightmostSetBit) != 0) {
                bucket1 ^= nums[i]; 
            } else {
                bucket2 ^= nums[i];
            }
        }
        return new int[]{bucket1, bucket2};
    }
}
