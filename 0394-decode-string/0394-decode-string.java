class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuffer ans = new StringBuffer();
        int nums = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int r = ch - '0';
                nums = (nums * 10) + r;
            }
            else if(ch == '['){
                st.push((char)nums);
                st.push(ch);
                nums = 0;
            }
            else if(ch == ']'){
                StringBuffer sb = new StringBuffer();
                while(!st.isEmpty() && st.peek() != '['){
                    sb.append(st.pop());
                }
                st.pop();
                int count = (int)st.pop();
                while(count > 0){
                    for(int j=sb.length()-1;j>=0;j--){
                        st.push(sb.charAt(j));
                    }
                    count--;
                }
            }
            else{
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }
        return ans.toString();
    }
}