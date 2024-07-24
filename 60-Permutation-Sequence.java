class Solution {
    public String getPermutation(int n, int k) {
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }
        List<Integer> stack = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n];
        rucurPermutation(nums,stack,freq,ans,k);
        StringBuffer sb = new StringBuffer();
        for(int i:ans.get(ans.size() - 1)){
            sb.append(i);
        }
        return sb.toString();
    }
    public void rucurPermutation(int nums[],List<Integer> stack,boolean[] freq,List<List<Integer>> ans,int k){
        if(stack.size() == nums.length){
            ans.add(new ArrayList<>(stack));
            return;
        }
        if(ans.size() != k){
            for(int i=0;i<nums.length;i++){
                if(!freq[i]){
                    freq[i] = true;
                    stack.add(nums[i]);
                    rucurPermutation(nums,stack,freq,ans,k);
                    freq[i] = false;
                    stack.remove(stack.size() - 1);
                }
            }
        }
    }
}