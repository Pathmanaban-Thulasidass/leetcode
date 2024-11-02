class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(st.size() >= 2){
                char top1 = st.pop();
                if(ch == top1){
                    char top2 = st.pop();
                    if(ch != top2){
                        st.push(top2);
                    }
                    st.push(top1);
                    st.push(ch);
                }
                else{
                    st.push(top1);
                    st.push(ch);
                }
            }
            else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}