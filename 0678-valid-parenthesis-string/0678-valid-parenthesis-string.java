class Solution {
    public boolean checkValidString(String s) {
        char[] ch = s.toCharArray();
        int a = 0; // )
        int b = 0; // (
        for (char c : ch) {
            if (c == '(') {
                a++;
                b++;
            } else if (c == ')') {
                a = Math.max(0, a - 1);
                b--;
            } else {
                a = Math.max(0, a - 1);
                b++;
            }
            if (b < 0)
                return false;
        }
        return a == 0;
    }
}