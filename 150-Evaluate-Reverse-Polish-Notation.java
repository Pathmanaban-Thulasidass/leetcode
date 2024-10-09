class Solution {
    public int evalRPN(String[] token) {
        Stack<Integer> st = new Stack<>();
        int n = token.length;
        for(int i=0;i<n;i++){
            if(token[i].equals(\+\)){
                st.push(st.pop() + st.pop());
            }
            else if(token[i].equals(\-\)){
                int op1 = st.pop();
                int op2 = st.pop();
                st.push(op2 - op1);
            }
            else if(token[i].equals(\*\)){
                st.push(st.pop() * st.pop());
            }
            else if(token[i].equals(\/\)){
                int op1 = st.pop();
                int op2 = st.pop();
                st.push(op2 / op1);
            }
            else{
                int num = Integer.parseInt(token[i]);
                st.push(num);
            }
        }
        return st.pop(); 
    }
}