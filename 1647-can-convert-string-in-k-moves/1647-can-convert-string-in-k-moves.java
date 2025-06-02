class Solution {
    public boolean canConvertString(String s, String t, int k) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2)
            return false;
        int step[] = new int[26];
        for(int i=0;i<n1;i++){
            if(s.charAt(i) != t.charAt(i)){
                int temp1 = s.charAt(i) - 'a';
                int temp2 = t.charAt(i) - 'a';
                int diff = (temp2 - temp1 + 26) % 26;
                if(step[diff] == 0){
                    step[diff] = diff;
                }
                else{
                    step[diff] += 26;
                }
                if(step[diff] > k)
                    return false;
            }
        }
        return true;
    }
}