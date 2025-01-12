class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0){
            return false;
        }
        int a = 0; 
        int b = 0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i) == '1'){
                if(s.charAt(i) == '('){
                    a++;
                    b++;
                }
                else{
                    a = Math.max(0, a - 1);
                    b--;
                }
            }
            else{
                a = Math.max(0, a - 1);
                b++;
            }
            if(b < 0)
                return false;
        }
        return a == 0;
    }
}