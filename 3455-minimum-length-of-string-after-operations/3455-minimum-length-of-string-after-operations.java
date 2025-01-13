class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int count = 0;
        int freq[] = new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] >= 3){
                if(freq[i] % 2 == 0){
                    count += 2;
                }
                else{
                    count += 1;
                }
            }
            else{
                count += freq[i];
            }
        }
        return count;
    }
}