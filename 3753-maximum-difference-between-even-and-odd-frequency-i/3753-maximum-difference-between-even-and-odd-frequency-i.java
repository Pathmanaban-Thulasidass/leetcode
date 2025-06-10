class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int freq[] = new int[26];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] == 0)
                continue;
            for(int j=i+1;j<26;j++){
                if(freq[j] == 0)
                    continue;
                if(freq[i] % 2 == 0 && freq[j] % 2 != 0){
                    ans = Math.max(ans,freq[j] - freq[i]);
                }
                else if(freq[i] % 2 != 0 && freq[j] % 2 == 0){
                    ans = Math.max(ans,freq[i] - freq[j]);
                }
            }
        }
        return ans;
    }
}