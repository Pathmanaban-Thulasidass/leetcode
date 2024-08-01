class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        for(char c : s.toCharArray()){
            stack.push(c);
            if(c == '('){
                cnt++;
            }
            else{
                cnt--;
                if(cnt == 0){
                    for(int i=1;i<stack.size() - 1; i++){
                        sb.append(stack.get(i));
                    }
                    stack.clear();
                }
            }
        }
        return sb.toString();
    }
}