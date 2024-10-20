class Solution {
    public boolean parseBoolExpr(String exp) {
        Stack<Character> st = new Stack<>();
        int n = exp.length();
        int trueCount = 0;
        int falseCount = 0;
        for(int i=0;i<n;i++){
            char ch = exp.charAt(i);
            if(ch == ')'){
                trueCount = 0;
                falseCount = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    char peek = st.peek();
                    if(peek == 't')
                        trueCount++;
                    else if(peek == 'f')
                        falseCount++;
                    st.pop();
                }
                st.pop(); //to remove the '(' from stack
                char operator = st.pop();
                if(operator == '&'){
                    if(falseCount > 0)
                        st.push('f');
                    else
                        st.push('t');
                }
                else if(operator == '|'){
                    if(trueCount > 0)
                        st.push('t');
                    else
                        st.push('f');
                }
                else{
                    if(trueCount > 0)
                        st.push('f');
                    else
                        st.push('t');
                }
            }
            else{
                if(ch != ',')
                    st.push(ch);
            }
        }
        return st.peek() == 't';
    }
}