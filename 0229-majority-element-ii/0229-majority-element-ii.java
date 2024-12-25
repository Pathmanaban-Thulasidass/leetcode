class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int ele1 = -1, ele2 = -1; 
        int count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else if (count1 == 0) {
                ele1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                ele2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == ele1) {
                count1++;
            } else if (num == ele2) {
                count2++;
            }
        }

        if (count1 > n / 3) ans.add(ele1);
        if (count2 > n / 3) ans.add(ele2);

        return ans;
    }
}
