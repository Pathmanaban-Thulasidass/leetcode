class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int left = 0; left <= (m - n); left++) {
            if (check(n, s2, freq, left, left + n - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(int n, String s2, int[] freq, int left, int right) {
        int[] tempFreq = new int[26];
        for (int i = left; i <= right; i++) {
            tempFreq[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != tempFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
