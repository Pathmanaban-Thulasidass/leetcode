class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        helperFun(0,k,nums,new ArrayList<>());
        return count - 1; // Because [] is also subset
    }
    public void helperFun(int index,int k,int[] nums,List<Integer> inner){
        if(nums.length == index){
            if(check(inner,k)){
                count++;
            }
            return;
        }
        //Take
        inner.add(nums[index]);
        helperFun(index + 1,k,nums,inner);
        //Don't take
        inner.remove(inner.size() - 1);
        helperFun(index + 1,k,nums,inner);

    }
    public boolean check(List<Integer> inner,int k){
        int size = inner.size();
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if((inner.get(j) - inner.get(i)) == k)
                    return false;
            }
        }
        return true;
    }
}