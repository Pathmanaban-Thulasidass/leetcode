class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3)
            return false;
        boolean containsVowel = false;
        boolean containsCon = false;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLetter(ch)){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                    containsVowel = true;
                }
                else{
                    containsCon = true;
                }
            }
            else if(Character.isDigit(ch)){
                continue;
            }
            else{
                return false;
            }
        }
        return containsCon && containsVowel;
    }
}