class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        st.push("/");
        String arr[] = path.split("/");
        StringBuffer sb = new StringBuffer();
        int n = arr.length;
        for(int i=0;i<n;i++){
            String cur = arr[i];
            int len = cur.length();
            if(len > 0){
                if(len == 1 && cur.charAt(0) == '.'){
                    continue;
                }
                else if(len == 2){
                    if(cur.charAt(0) == '.' && cur.charAt(1) == '.'){
                        if(!st.isEmpty() && st.peek().length() > 1)
                            st.pop();
                    }
                    else{
                        st.push(cur + "/");
                    }
                }
                else{
                    st.push(cur + "/");
                }
            }
        }
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        } 
        if(sb.length() > 1 && sb.charAt(sb.length() - 1) == '/'){
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}