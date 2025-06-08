class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int val = 1;
        for(int i=1;i<=9;i++){
            if(i <= n)
                helper(i,n,ans);
            else
                break;
        }
        return ans;
    }
    public void helper(int val,int n,List<Integer> ans){
        ans.add(val);
        for(int i=0;i<=9;i++){
            int next = (val * 10) + i;
            if(next <= n)
                helper(next,n,ans);
        }
    }
}