class Solution {
    public int[] numsSameConsecDiff(int n, int k) {     
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(i, i, k, n - 1, ans);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    public void helper(int currentNum, int lastDigit, int k, int remainingDigits, List<Integer> ans) {
        if (remainingDigits == 0) {
            ans.add(currentNum);
            return;
        }
        if (lastDigit + k < 10) {
            helper(currentNum * 10 + (lastDigit + k), lastDigit + k, k, remainingDigits - 1, ans);
        }
        if (k != 0 && lastDigit - k >= 0) {
            helper(currentNum * 10 + (lastDigit - k), lastDigit - k, k, remainingDigits - 1, ans);
        }
    }
}
