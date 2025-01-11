class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        int odd = 0;
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if((freq[i] & 1) == 1){
                odd++;
            }
        }
        return odd <= k && n >= k;
    }
}