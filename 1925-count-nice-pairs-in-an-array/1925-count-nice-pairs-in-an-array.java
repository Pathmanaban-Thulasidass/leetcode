class Solution {
    final int MOD = (int)(1e9 + 7);
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            long diff = nums[i] - reverse(nums[i]);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        for(long key : map.keySet()) {
            long freq = map.get(key);
            count = (count + (freq * (freq - 1) / 2) % MOD) % MOD;
        }
        return (int) count;
    }

    public long reverse(int num) {
        long rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
