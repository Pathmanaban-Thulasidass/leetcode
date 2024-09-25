class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun(0,0,n,new StringBuffer(),ans);
        return ans;
    }
    public void fun(int left,int right,int n,StringBuffer inner,List<String> ans){

        if(left == right && left == n){
            ans.add(inner.toString());
            return;
        }
        if (left < n) {
            inner.append('(');
            fun(left + 1, right, n, inner, ans);
            inner.setLength(inner.length() - 1); 
        }

        if (right < left) {
            inner.append(')');
            fun(left, right + 1, n, inner, ans);
            inner.setLength(inner.length() - 1); 
        }

    }
}