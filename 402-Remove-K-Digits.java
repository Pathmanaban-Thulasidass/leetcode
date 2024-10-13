class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> monoSt = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!monoSt.isEmpty() && k > 0 && monoSt.peek() > digit) {
                monoSt.pop();
                k--;
            }
            monoSt.push(digit);
        }
        while (k > 0) {
            monoSt.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        for (char digit : monoSt) {
            result.append(digit);
        }
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? \0\ : result.toString();
    }
}
