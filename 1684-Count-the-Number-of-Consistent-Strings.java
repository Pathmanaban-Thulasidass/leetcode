class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int c  = 0;
        int allowedFreq[] = new int[26];
        for(char ch : allowed.toCharArray()){
            allowedFreq[ch-'a'] = 1;
        }
        boolean isConsistent = true; 
        for(int i=0;i<words.length;i++){
            isConsistent = true;
            for(char ch : words[i].toCharArray()){
                if(allowedFreq[ch-'a'] == 0){
                    isConsistent = false; 
                    break;
                }
            }
            if(isConsistent){
                c++;
            }
        }
        return c;
    }
}