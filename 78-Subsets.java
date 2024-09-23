class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int size = 1 << n;
        System.out.println(size);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<size;i++){
            List<Integer> inner = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & 1 << j) != 0){
                    inner.add(nums[j]);
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}