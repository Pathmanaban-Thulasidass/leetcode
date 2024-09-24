class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
    public void findCombinations(int index,int k,int target,List<Integer> inner,List<List<Integer>> ans){
        if(inner.size() == k)
        {
            if(target == 0)
                ans.add(new ArrayList<>(inner));
            return;
        }

        for(int i=index;i<=9;i++){
            inner.add(i);
            findCombinations(i+1,k,target-i,inner,ans);
            inner.remove(inner.size() - 1);
        }
    }
}