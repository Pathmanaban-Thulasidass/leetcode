class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length();
        int n2 = magazine.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0;i<n1;i++){
            freq1[ransomNote.charAt(i) - 'a']++;
        }
        for(int i=0;i<n2;i++){
            freq2[magazine.charAt(i) - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i] > freq2[i])
                return false;
        }
        return true;
    }
}