class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[3];
        int left = 0;
        int right = 0;
        int subArray = 0;
        while(right < n){
            freq[s.charAt(right) - 'a']++;
            while(isValid(freq)){
                // subArray++;
                // subArray += (n - right - 1);
                //Instead of using above two lines
                subArray += (n - right); 
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return subArray;
    }
    public boolean isValid(int freq[]){
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}