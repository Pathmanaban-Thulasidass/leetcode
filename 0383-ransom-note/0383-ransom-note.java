class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        int freq[] = new int[26];
        for(int i=0;i<n2;i++){
            freq[magazine.charAt(i) - 'a']++;
        }
        for(int i=0;i<n1;i++){
            freq[ransomNote.charAt(i) - 'a']--;
            if(freq[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}