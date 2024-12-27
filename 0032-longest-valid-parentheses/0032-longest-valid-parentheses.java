class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        Stack<Integer> st = new Stack<>();
        int arr[] = new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    int index = st.pop();
                    arr[i] = 1;
                    arr[index] = 1;
                }
            }
        }
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] == 0){
                len = 0;
            }
            else{
                len += arr[i];
            }
            max = Math.max(max,len);
        }
        return max;
    }
}