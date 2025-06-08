class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int val = 1;
        for(int i=1;i<=9;i++){
            helper(i,n,ans);
        }
        return ans;
    }
    public void helper(int val,int n,List<Integer> ans){
        if(val > n){
            return;
        }
        ans.add(val);
        for(int i=0;i<=9;i++){
            helper((val * 10) + i,n,ans);
        }
    }
}