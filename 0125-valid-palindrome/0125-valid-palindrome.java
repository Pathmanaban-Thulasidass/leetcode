class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while(left < right){
            while(left < n && (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left)))){
                left++;
            }
            while(right >= 0 && (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right)))){
                right--;
            }
            if(left < n && right >= 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false; 
            }
            left++;
            right--;
        }
        return true;
    }
}