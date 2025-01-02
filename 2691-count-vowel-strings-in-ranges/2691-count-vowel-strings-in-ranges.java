class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n1 = words.length;
        int n2 = queries.length;
        int[] freq = new int[n1];
        int[] ans = new int[n2];
        for(int i=0;i<n1;i++){
            int n = words[i].length();
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(n-1))){
                freq[i]++;
            }
        }
        for(int i=1;i<n1;i++){
            freq[i] += freq[i-1];
        }
        for(int i=0;i<n2;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l == 0)
                ans[i] = freq[r];
            else{
                ans[i] = freq[r] - freq[l-1];
            }

        }
        return ans;
    }
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}