class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
    public void findCombination(int index,int k,int n,List<Integer> inner,List<List<Integer>> ans){
        if(inner.size() == k){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i=index;i<=n;i++){
            inner.add(i);
            findCombination(i + 1,k,n,inner,ans);
            inner.remove(inner.size() - 1);
        }
    }
}