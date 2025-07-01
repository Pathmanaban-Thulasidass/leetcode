class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 0;
        char last = word.charAt(0);
        int ans = 1;
        for(int i=1;i<n;i++){
            if(last == word.charAt(i)){
                count++;
            }
            else{
                last = word.charAt(i);
                ans += count;
                count = 0;
            }
        }
        ans += count;
        return ans;
    }
}