class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length();
        int freq[] = new int[26];
        int preRemovedSum = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                count = 0;
                int temp = freq[i] + k;
                for(int j=i;j<26;j++){
                    if(freq[j] > temp){
                        count += freq[j] - temp;
                    }
                }
                ans = Math.min(ans,count + preRemovedSum);
            }
            preRemovedSum += freq[i];
        }
        return ans;
    }
}