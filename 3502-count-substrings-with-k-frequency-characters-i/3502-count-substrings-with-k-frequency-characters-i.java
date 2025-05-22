class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        int count = 0;
        int obeyEleCount = 0;
        int left = 0;
        int right = 0;
        while(right < n){
            int ch = s.charAt(right) - 'a';
            freq[ch]++;
            if(freq[ch] == k){
                obeyEleCount++;
            }
            while(left <= right && obeyEleCount > 0){
                count += n - right;
                ch = s.charAt(left) - 'a';
                freq[ch]--;
                if(freq[ch] == k - 1){
                    obeyEleCount--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}